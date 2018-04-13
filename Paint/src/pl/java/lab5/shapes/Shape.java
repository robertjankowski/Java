package pl.java.lab5.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import pl.java.lab5.Constants;

public abstract class Shape {

	List<Integer> xPos;
	List<Integer> yPos;
	Color color;
	int lineWidth;

	public Shape() {
		xPos = new ArrayList<>();
		yPos = new ArrayList<>();
		color = Constants.getLnColor();
		lineWidth = Constants.getLineWidth();
	}

	public void addPoint(int x, int y) {
		xPos.add(x);
		yPos.add(y);
	}

	public void update(int x, int y) {
		if (xPos.size() > 1) {
			xPos.set(xPos.size() - 1, x);
			yPos.set(yPos.size() - 1, y);
		} else {
			xPos.add(x);
			yPos.add(y);
		}
	}

	public abstract void draw(Graphics2D g2d);

	public List<Integer> getxPos() {
		return xPos;
	}

	public void setxPos(List<Integer> xPos) {
		this.xPos = xPos;
	}

	public List<Integer> getyPos() {
		return yPos;
	}

	public void setyPos(List<Integer> yPos) {
		this.yPos = yPos;
	}



}
