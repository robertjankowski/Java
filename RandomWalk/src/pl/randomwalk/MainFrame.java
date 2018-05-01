package pl.randomwalk;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import pl.randomwalk.drawpanel.DrawPanel;
import pl.randomwalk.drawpanel.DrawPanelListener;
import pl.randomwalk.menu.MenuBar;
import pl.randomwalk.menu.MenuBarListener;

public class MainFrame extends JFrame {

	private static final int FRAME_WIDHT = 800;
	private static final int FRAME_HEIGHT = 600;
	private DrawPanel drawPanel;
	private DrawPanelListener drawPanelListener;
	private MenuBar menuBar;
	private MenuBarListener menuBarListener;
	private Chart chart = new Chart();
	
	public MainFrame() {
		super("Random walk");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(FRAME_WIDHT, FRAME_HEIGHT));
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

		drawPanel = new DrawPanel(chart);
		drawPanelListener = new DrawPanelListener(drawPanel);
		menuBar = new MenuBar();
		menuBarListener = new MenuBarListener(menuBar, drawPanel,chart);
		this.setJMenuBar(menuBar);
		this.add(drawPanel, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new MainFrame().setVisible(true);
		});
	}
}
