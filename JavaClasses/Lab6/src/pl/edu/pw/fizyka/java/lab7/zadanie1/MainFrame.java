package pl.edu.pw.fizyka.java.lab7.zadanie1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author robjan
 *
 */
public class MainFrame extends JFrame {

	private static final int MY_WIDTH = 500;
	private static final int MY_HEIGHT = 500;

	private CustomButton customButton;
	private ColorChangingPanel colorChangingPanel;
	private ChangingCircle changingCircle;

	public MainFrame() {
		super("Zadanie 1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(MY_WIDTH, MY_HEIGHT));
		this.setMinimumSize(getPreferredSize());
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension size = getSize();
				Dimension min = getMinimumSize();
				if (size.getWidth() < min.getWidth()) {
					setSize((int) min.getWidth(), (int) size.getHeight());
				}
				if (size.getHeight() < min.getHeight()) {
					setSize((int) size.getWidth(), (int) min.getHeight());
				}
			}
		});
		this.setLocationRelativeTo(null);
		customButton = new CustomButton();
		colorChangingPanel = new ColorChangingPanel();
		changingCircle = new ChangingCircle();
		this.add(customButton, BorderLayout.PAGE_START);
		this.add(colorChangingPanel, BorderLayout.WEST);
		this.add(changingCircle,BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new MainFrame().setVisible(true);
		});
	}
}
