package pl.edu.pw.fizyka.java.lab7.zadanie1;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circle {

	float fi;
	float speed = 5;
	float radius;
	int r = 10;
	int x0;
	int y0;

	/**
	 * 
	 * @param radius = const
	 * @param fi
	 * @param x0 = const
	 * @param y0 = const
	 */
	public Circle(float radius, float fi, int x0, int y0) {
		this.radius = radius;
		this.fi = fi;
		this.x0 = x0;
		this.y0 = y0;
	}

	public void update(float dt) {
		fi += speed * dt;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.fillOval(x0 + (int) (radius * Math.cos(fi)) - r / 2, y0 - (int) (radius * Math.sin(fi)) - r / 2, r, r);
	}

}
