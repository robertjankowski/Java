package pl.java.lab5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import pl.java.lab5.shapes.Shape;

public class DrawPanel extends JPanel {

	Graphics2D g2d;
	List<Shape> shapes;
	Shape shape = null;
	BottomPanel bottomPanel;
	DrawPanelListener drawListener;
	BufferedImage image;
	int width, height;

	public DrawPanel(BottomPanel bottomPanel) {
		this.setPreferredSize(new Dimension(600, 600));
		shapes = new ArrayList<>();
		this.setBackground(Constants.bgColor);
		this.bottomPanel = bottomPanel;
		drawListener = new DrawPanelListener(this, bottomPanel);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				width = getWidth();
				height = getHeight();
			}
		});
		width = this.getWidth();
		height = this.getHeight();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		if (image != null)
			g2d.drawImage(image, (width - image.getWidth()) / 2, (height - image.getHeight()) / 2, this);
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(g2d);
		}
		if (shape != null) {
			shape.draw(g2d);
		}
	}

	public void setBackgroudImage(BufferedImage image) {
		this.image = image;
		double imageRatio = (double) image.getWidth() / image.getHeight();

		int newWidth = width;
		int newHeight = height;

		if ((double) width / height > imageRatio)
			newWidth = (int) imageRatio * height;
		else
			newHeight = (int) (width / imageRatio);

		Image img = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		BufferedImage bgImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D bGr = bgImage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();
		image = bgImage;
		repaint();

	}
}
