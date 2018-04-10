package pl.randomwalk.custompoint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class CustomPoint extends Point {

	Color color;

	public CustomPoint(int x, int y) {
		super(x, y);
		color = Preferences.getPOINT_COLOR();
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(Preferences.BLOCK_SIZE + (Preferences.BLOCK_SIZE * x),
				Preferences.BLOCK_SIZE + (Preferences.BLOCK_SIZE * y), Preferences.BLOCK_SIZE, Preferences.BLOCK_SIZE);
	}

}
