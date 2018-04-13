package pl.java.lab5.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Line extends Shape {

	public Line() {
		super();
	}

	@Override
	public void update(int x, int y) {
		xPos.add(x);
		yPos.add(y);
	}

	@Override
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < xPos.size() - 1; ++i) {
			g2d.setColor(color);
			g2d.setStroke(new BasicStroke(lineWidth));
			g2d.drawLine(xPos.get(i), yPos.get(i), xPos.get(i + 1), yPos.get(i + 1));
		}
	}

}
