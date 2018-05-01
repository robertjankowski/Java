package pl.gameoflife;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -394797340997205956L;
	public static final int WIDHT = 1000;
	public static final int HEIGHT = 800;

	private MenuBar menuBar;
	private GameBoard gameBoard;
	@SuppressWarnings("unused")
	private GameBoardListener gameBoardListner;
	@SuppressWarnings("unused")
	private MenuListener menuListener;
	private OptionsPanel optionsPanel;

	public MainFrame() throws AWTException {
		super("Game of life");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDHT, HEIGHT));
		this.setMinimumSize(getPreferredSize());
		this.pack();
		this.setLocationRelativeTo(null);
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

		menuBar = new MenuBar();
		gameBoard = new GameBoard();
		gameBoardListner = new GameBoardListener(gameBoard);
		menuListener = new MenuListener(menuBar, gameBoard);
		optionsPanel = new OptionsPanel(gameBoard);
		this.setJMenuBar(menuBar);
		this.add(gameBoard, BorderLayout.CENTER);
		this.add(optionsPanel, BorderLayout.WEST);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new MainFrame().setVisible(true);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		});
	}

}
