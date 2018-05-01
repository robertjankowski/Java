package pl.edu.pw.fizyka.java.lab7.zadanie1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

public class ChangingCircle extends JPanel implements Runnable {

	Graphics2D g2d;
	int radius = 10;
	double deg = 0;
	List<Circle> circles;
	float delta = 0.01f;

	// dokoncz zeby zmieniał się rozmiar
	public ChangingCircle() {
		new Thread(this).start();
		circles = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			circles.add(new Circle(100, (float) (Math.PI / 8 * i), 150, 200));
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);

		// to do zmieniającej się wielkości kółka
		// g2d.translate(-radius / 2, -radius / 2);
		// g2d.drawOval(100, 100, radius, radius);

		for (Circle c : circles) {
			c.update(delta);
			c.draw(g2d);
		}

	}

	@Override
	public void run() {
		Toolkit.getDefaultToolkit().sync();
		// to do zmieniającej się wielkości kólka

		/*
		 * while (true) { try { Thread.sleep(200); } catch (InterruptedException ex) {
		 * ex.printStackTrace(); } radius += 10; if (radius > 100) { radius -= radius; }
		 * repaint();
		 * 
		 * }
		 */

		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			delta += 0.01;
			if(delta >= 0.5) {
				delta -= 0.5;
			}
			repaint();
		}
	}

}
