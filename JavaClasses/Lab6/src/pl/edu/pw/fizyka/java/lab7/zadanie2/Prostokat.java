package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class Prostokat {

	private int xPos = 50;
	private int yPos = 50;
	private int xV = ThreadLocalRandom.current().nextInt(-5, 6);
	private int yV = ThreadLocalRandom.current().nextInt(-5, 6);
	private int width = 20;
	private int height = 20;
	private Color color = Color.BLACK;

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public int getY() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void paint(Graphics g) {
		g.setColor(getColor());
		g.fillRect(xPos, yPos, getWidth(), getHeight());
	}

	public int getxV() {
		return xV;
	}

	public void setxV(int xV) {
		this.xV = xV;
	}

	public int getyV() {
		return yV;
	}

	public void setyV(int yV) {
		this.yV = yV;
	}

}
