package pl.harmonographs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements Runnable {

	int radius = 10;
	// freq
	static double f1 = 5;
	static double f2 = 3;
	static double f3 = 1.002;
	static double f4 = 0.002;
	// phase
	static double p1 = Math.PI / 16;
	static double p2 = 3 * Math.PI / 2;
	static double p3 = Math.PI;
	static double p4 = 0;
	// const
	static double d1 = 0.02;
	static double d2 = 0.0314;
	static double d3 = 0.02;
	static double d4 = 0;

	// time
	double time = 0;
	static double waitTime = 100;
	// coords
	int x;
	int y;

	// for a line
	int x1, x2;
	int y1, y2;

	List<Line2D> lines = new ArrayList<>();
	ExecutorService service;
	boolean isSuspended = false;

	public DrawPanel() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(300 - radius / 2, 300 - radius / 2);
		x = (int) (150 * Math.sin(f1 * time + p1) * Math.exp(-time * d1)
				+ 150 * Math.sin(f2 * time + p2) * Math.exp(-time * d2));
		y = (int) (150 * Math.sin(f3 * time + p3) * Math.exp(-time * d3)
				+ 150 * Math.sin(f4 * time + p4) * Math.exp(-time * d4));
		if (lines != null) {
			try {
				for (Line2D l : lines) {
					g2d.draw(l);
				}
			} catch (ConcurrentModificationException ex) {
			}
		}
		g2d.fillOval(x, y, radius, radius);
	}

	public void resetPanel() {
		lines.clear();
	}

	public void start() {
		service = Executors.newFixedThreadPool(1);
		service.execute(this);
		isSuspended = false;
	}

	public void stop() {
		isSuspended = true;
	}

	@Override
	public void run() {
		synchronized (this) {
			while (!isSuspended) {
				Toolkit.getDefaultToolkit().sync();
				try {
					Thread.sleep((long) (1000/waitTime));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				x1 = x;
				y1 = y;
				time += 0.01;
				repaint();
				x2 = x;
				y2 = y;
				lines.add(new Line2D.Double(x1, y1, x2, y1));
			}
		}
	}

}
