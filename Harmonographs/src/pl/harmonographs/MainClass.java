package pl.harmonographs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass extends JFrame {

	private static final int MY_WIDTH = 600;
	private static final int MY_HEIGHT = 600;

	private DrawPanel drawPanel;
	private OptionsPanel optionsPanel;
	// getting name of package
	static Class<?> classs = MainClass.class;
	static Package pac = classs.getPackage();
	static String name = pac.getName().substring(3);

	public MainClass() {
		super(name);
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
		drawPanel = new DrawPanel();
		optionsPanel = new OptionsPanel(drawPanel);
		this.add(drawPanel, BorderLayout.CENTER);
		this.add(optionsPanel, BorderLayout.PAGE_START);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new MainClass().setVisible(true);
		});
	}
}
