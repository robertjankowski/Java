package pl.java.lab7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	public static final int WIDHT = 800;
	public static final int HEIGHT = 600;

	private MenuBar menuBar;
	private BottomPanel bottomPanel;
	private EditorPanel editorPanel;
	private MenuListener menuListener;

	public MainFrame() throws IncorrectSpellingException {
		super("Abecadło");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		editorPanel = new EditorPanel();
		bottomPanel = new BottomPanel(editorPanel);
		menuListener = new MenuListener(menuBar, editorPanel);
		this.setJMenuBar(menuBar);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		this.add(editorPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new MainFrame().setVisible(true);
			} catch (IncorrectSpellingException e) {
				e.printStackTrace();
			}
		});
	}

}
