package pl.java.lab5;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomButtom extends JButton {

	BufferedImage buttonIcon;
	String name;
	
	public CustomButtom(String path) throws IOException {
		buttonIcon = ImageIO.read(new File(path));
		this.setIcon(new ImageIcon(buttonIcon));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		name = path;
		String[] parts = name.split("\\.");
		name = parts[0];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
