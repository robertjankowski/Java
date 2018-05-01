package pl.java.tictactoe;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DrawableButton extends JButton {

	public DrawableButton(int width,int height) {
		setSize(new Dimension(width,height));
		Image image = circle.getImage();
		Image newImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		circle = new ImageIcon(newImage);

		image = cross.getImage();
		newImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		cross = new ImageIcon(newImage);

	}

	public void draw() {
		if (content.equals(Content.EMPTY)) {
			if (moveCount % 2 == 0) {
				this.setIcon(circle);
				content = Content.CIRCLE;
			} else {
				this.setIcon(cross);
				content = Content.CROSS;
			}
			moveCount++;
		}
	}

	public Content getContent() {
		return content;
	}
	
	public void setContent(Content c) {
		this.content = c;
	}
	
	public static int moveCount = 0;
	public ImageIcon circle = new ImageIcon(getClass().getResource("O.png"));
	public ImageIcon cross = new ImageIcon(getClass().getResource("X.png"));

	public Content content = Content.EMPTY;
}
