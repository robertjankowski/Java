package pl.java.lab5;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Robot;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

	DrawPanel drawPanel;
	DrawPanelListener drawPanelListener;
	Robot robot;

	public FloodFill(DrawPanel drawPanel, DrawPanelListener drawPanelListener) {
		this.drawPanel = drawPanel;
		this.drawPanelListener = drawPanelListener;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// do poprawy, cos nie tak z kolorami
	public void paintBucket(int x, int y, Color target, Color replacement) {
		System.out.println(robot.getPixelColor(x, y));
		if (x <= 0) return;
		if (y <= 0) return;
		if(target == replacement) return;
		pencil(x,y,replacement);
		if(robot.getPixelColor(x-1, y).equals(target)) {
			paintBucket(x-1, y, target, replacement);
		}
		if(robot.getPixelColor(x+1, y).equals(target)) {
			paintBucket(x+1, y, target, replacement);
		}
		if(robot.getPixelColor(x, y-1).equals(target)) {
			paintBucket(x, y-1, target, replacement);
		}
		if(robot.getPixelColor(x, y+1).equals(target)) {
			paintBucket(x, y+1, target, replacement);
		}
		
 	}

	public void pencil(int x, int y, Color replacemanet) {
		Graphics g = drawPanel.getGraphics();
		g.setColor(replacemanet);
		g.fillRect(x, y, 1, 1);

	}

}
