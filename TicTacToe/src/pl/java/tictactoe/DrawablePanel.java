package pl.java.tictactoe;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import pl.java.tictactoe.MainWindow;

public class DrawablePanel extends JPanel implements MouseListener {

	public static int moveCount = 0;
	private JLabel label = new JLabel();

	public ImageIcon circle = new ImageIcon(getClass().getResource("O.png"));
	public ImageIcon cross = new ImageIcon(getClass().getResource("X.png"));

	public Content content = Content.EMPTY;

	public DrawablePanel(int width, int height) {
		super();
		setSize(width, height);

		Image image = circle.getImage();
		Image newImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		circle = new ImageIcon(newImage);

		image = cross.getImage();
		newImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		cross = new ImageIcon(newImage);

		setLayout(new GridLayout(1, 1));
		Border border = BorderFactory.createLineBorder(Color.black, 2);

		setBorder(border);
		add(label);
		label.addMouseListener(this);
	}

	public void draw() {
		if (content.equals(Content.EMPTY)) {
			if (moveCount % 2 == 0) {
				label.setIcon(circle);
				content = Content.CIRCLE;
			} else {
				label.setIcon(cross);
				content = Content.CROSS;
			}
			moveCount++;
		}
	}
	public Content getContent() {
		return content;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		draw();

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
