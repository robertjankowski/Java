package pl.java.lab5;

import java.awt.Color;
import java.awt.Graphics;

public class FloodFill {

	DrawPanel drawPanel;
	DrawPanelListener drawPanelListener;

	public FloodFill(DrawPanel drawPanel, DrawPanelListener drawPanelListener) {
		this.drawPanel = drawPanel;
		this.drawPanelListener = drawPanelListener;
	}

	// do poprawy ! StackOverFlow
	public void paintBucket(int x, int y, Color toFill) {
		if (x >= 0 && y >= 0 && x < 700 && y < 700
				&& drawPanelListener.getColor(x, y).equals(toFill)) {
			pencil(x, y);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			paintBucket(x - 1, y, toFill);
			paintBucket(x, y - 1, toFill);
			paintBucket(x + 1, y, toFill);
			paintBucket(x, y + 1, toFill);
		
		}
	}

	public void pencil(int x, int y) {
		Graphics g = drawPanel.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 1, 1);

	}

}
