package pl.java.lab2.przyklad3;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawablePanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillRect(50, 50, 150, 150);

		g.setColor(Color.blue);
		g.fillOval(250, 250, 150, 150);
	}

}
