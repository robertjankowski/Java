package pl.java.lab5;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ToolsPanel extends JPanel {

	CustomButtom eraser;
	CustomButtom pencil;
	CustomButtom line;
	CustomButtom rectangle;
	CustomButtom circle;
	CustomButtom fillShape;
	
	public ToolsPanel() throws IOException {
		this.setLayout(new GridLayout(6, 2, 10, 20));
		
		eraser = new CustomButtom("rubber.jpeg");
		pencil = new CustomButtom("pencil.jpg");
		line = new CustomButtom("line.jpg");
		rectangle = new CustomButtom("rectangle.png");
		circle = new CustomButtom("circle.png");
		fillShape = new CustomButtom("fill.png");

		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Tools");
		this.add(eraser);
		this.add(pencil);
		this.add(line);
		this.add(rectangle);
		this.add(circle);
		this.add(fillShape);
		this.setBorder(border);

	}

}
