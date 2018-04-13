package pl.java.lab5.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Rectangle extends Shape {

	public Rectangle() {
		super();
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(lineWidth));
		try {
			g2d.drawRect(Math.min(xPos.get(0), xPos.get(1)), Math.min(yPos.get(0), yPos.get(1)),
					Math.abs(-xPos.get(0) + xPos.get(1)), Math.abs(-yPos.get(0) + yPos.get(1)));
		} catch (IndexOutOfBoundsException ex) {
			g2d.drawLine(xPos.get(0), yPos.get(0), xPos.get(0), yPos.get(0));
		}
	}

}
