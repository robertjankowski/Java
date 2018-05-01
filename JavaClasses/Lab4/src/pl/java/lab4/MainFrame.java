package pl.java.lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainFrame extends JFrame implements ActionListener {

	public static final int WIDHT = 800;
	public static final int HEIGHT = 600;
	private TopPanel topPanel;
	private BottomPanel bottomPanel;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	private CenterPanel centerPanel;
	private Menu menu;
	private MenuListener menuListener;
	private EverythingListener everythingListener;

	public MainFrame() {
		super("DrawRectangle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(WIDHT, HEIGHT));
		this.setMinimumSize(getPreferredSize());
		topPanel = new TopPanel();
		bottomPanel = new BottomPanel();
		leftPanel = new LeftPanel();
		rightPanel = new RightPanel(leftPanel);
		centerPanel = new CenterPanel(rightPanel);
		menu = new Menu(this, centerPanel);
		menuListener = new MenuListener(centerPanel, menu);
		everythingListener = new EverythingListener(topPanel, bottomPanel, leftPanel, rightPanel, centerPanel);

		bottomPanel.bgColor.addActionListener(this);
		bottomPanel.lnColor.addActionListener(this);
		menu.line1px.addActionListener(menuListener);
		menu.line5px.addActionListener(menuListener);
		menu.line10px.addActionListener(menuListener);

		this.add(topPanel, BorderLayout.PAGE_START);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.add(centerPanel, BorderLayout.CENTER);
		this.setJMenuBar(menu);

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bottomPanel.bgColor) {
			Color color = JColorChooser.showDialog(null, "Change background color", Color.WHITE);
			centerPanel.setBackground(color);
			centerPanel.repaint();
		} else if (e.getSource() == bottomPanel.lnColor) {
			Color color = JColorChooser.showDialog(null, "Change line color", Color.BLACK);
			centerPanel.color = color;
			centerPanel.g2d.setColor(color);
			centerPanel.repaint();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

}
