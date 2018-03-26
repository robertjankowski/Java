package pl.java.lab5.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class StraightLine extends Shape {

	public StraightLine() {
		super();
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(lineWidth));
		try {
			g2d.drawLine(xPos.get(0), yPos.get(0), xPos.get(1), yPos.get(1));
		} catch (IndexOutOfBoundsException ex) {
			g2d.drawLine(xPos.get(0), yPos.get(0), xPos.get(0), yPos.get(0));
		}
	}

}
