package pl.java.lab5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	public static final int WIDHT = 1000;
	public static final int HEIGHT = 800;

	MenuBar menuBar;
	ToolsPanel toolsPanel;
	DrawPanel drawPanel;
	BottomPanel bottomPanel;

	MenuListener menuListener;
	ButtonAndLabelListener buttonAndLabelListener;

	public MainFrame() throws IOException {
		super("Paint");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(WIDHT, HEIGHT));
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
		this.setSize(WIDHT, HEIGHT);
		this.setLocationRelativeTo(null);

		menuBar = new MenuBar();
		toolsPanel = new ToolsPanel();
		bottomPanel = new BottomPanel();
		drawPanel = new DrawPanel(bottomPanel);

		menuListener = new MenuListener(menuBar, drawPanel);
		buttonAndLabelListener = new ButtonAndLabelListener(toolsPanel, bottomPanel);

		this.add(toolsPanel, BorderLayout.WEST);
		this.add(drawPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		this.setJMenuBar(menuBar);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				int save = JOptionPane.showConfirmDialog(drawPanel, "Do you want to save a file?", "Exit",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				// yes - 0 no - 1 cancel - 2
				if (save == 1) {
					System.exit(1);
				}
				if (save == 0) {
					menuListener.saveToFile(drawPanel);
				}
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new MainFrame().setVisible(true);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

}
