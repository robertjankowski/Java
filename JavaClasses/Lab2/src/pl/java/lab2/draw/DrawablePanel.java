package pl.java.lab2.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class DrawablePanel extends JPanel {

	private Random r = new Random();
	private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);

	private static int DELAY = 1000;
	Insets insets;
	Color[] colors = { Color.RED, Color.BLACK, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.GREEN };

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (insets == null) {
			insets = getInsets();
		}

		int x = insets.left;
		int y = insets.top;

		int width = getWidth() - insets.left - insets.right;
		int height = getHeight() - insets.bottom - insets.top;
		int start = 0;
		int steps = colors.length;
		int stepSize = 360 / steps;
		synchronized(colors) {
			for(int i=0; i<steps; i++) {
				g.setColor(colors[i]);
				g.fillArc(x, y, width, height, start, stepSize);
				start += stepSize;
			}
		}

		/*
		 * g.setColor(new Color(green, blue, red)); g.fillRect(50, 50, 150, 150);
		 * 
		 * g.setColor(new Color(red, green, blue)); g.fillOval(250, 250, 150, 150);
		 * 
		 * g.setColor(new Color(blue, red, green)); g.fillRoundRect(300, 50, 100, 100,
		 * 20, 20);
		 */
	}

	public void go() {
		TimerTask task = new TimerTask() {
			public void run() {
				Color c = colors[0];
				synchronized (colors) {
					System.arraycopy(colors, 1, colors, 0, colors.length - 1);
				}
				repaint();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0, DELAY);
	}

}
