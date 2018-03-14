package pl.java.lab4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	public static final int RADIUS = 150;
	static final double START_POSITION_X = MainFrame.WIDHT * 0.77 - 300;
	static final double START_POSITION_Y = MainFrame.HEIGHT * 0.77 - 230;
	public static final int MAX_VERTICLES = 33;
	Graphics2D g2d;
	Color color;
	BasicStroke stroke;
	RightPanel rightPanel;
	Polygon poly;

	public CenterPanel(RightPanel rightPanel) {
		this.rightPanel = rightPanel;
		setPreferredSize(new Dimension(596, 460));
		color = Color.BLACK;
		stroke = new BasicStroke(1);
		setPolygon();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.setStroke(stroke);
		g2d.drawPolygon(poly);
	}

	public void setPolygon() {
		int length = rightPanel.getxPosList().size();
		int[] xPos = new int[length];
		int[] yPos = new int[length];

		for (int i = 0; i < length; i++) {
			try {
				xPos[i] = Integer.parseInt(rightPanel.getxPosList().get(i).getText());
				yPos[i] = Integer.parseInt(rightPanel.getyPosList().get(i).getText());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		poly = new Polygon(xPos, yPos, length);
	}

	public void saveImage(String name, String type) {
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		g2d = image.createGraphics();
		paint(g2d);
		try {
			File outPutFile = new File(name + "." + type);
			ImageIO.write(image, type, outPutFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
