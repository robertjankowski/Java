package pl.java.lab4;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Menu extends JMenuBar {

	JMenu changeLineSize;
	JMenuItem line1px;
	JMenuItem line5px;
	JMenuItem line10px;
	JMenu savePolygon;
	JMenuItem screenShoot;
	JMenuItem save;
	JMenu lookMenu;
	UIManager.LookAndFeelInfo[] lookAndFeels;
	static final String toDesktop = "/home/robjan/Pulpit/";

	public Menu(MainFrame mainFrame, CenterPanel centerPanel) {
		lookAndFeels = UIManager.getInstalledLookAndFeels();
		changeLineSize = new JMenu("Line width");
		changeLineSize.setMnemonic(KeyEvent.VK_Z);
		savePolygon = new JMenu("Save");
		savePolygon.setMnemonic(KeyEvent.VK_S);
		lookMenu = new JMenu("Look and Feel");
		lookMenu.setMnemonic(KeyEvent.VK_L);
		line1px = new JMenuItem("1 px");
		line5px = new JMenuItem("5 px");
		line10px = new JMenuItem("10 px");
		changeLineSize.add(line1px);
		changeLineSize.add(line5px);
		changeLineSize.add(line10px);
		screenShoot = new JMenuItem("Screenshoot");
		screenShoot.addActionListener(event -> {
			try {
				Dimension dim = mainFrame.getSize();
				Rectangle rect = new Rectangle(dim);
				BufferedImage image = new Robot().createScreenCapture(rect);
				try {
					ImageIO.write(image, "png", new File(toDesktop + "file"));
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} catch (AWTException e) {
				System.out.println("Error " + e.getMessage());
			}
		});

		save = new JMenuItem("Save polygon");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "Please insert image name", "File name",
						JOptionPane.QUESTION_MESSAGE);
				String extension = JOptionPane.showInputDialog(null, "Please insert file extension", "File extnesion",
						JOptionPane.QUESTION_MESSAGE);
				centerPanel.saveImage(toDesktop + name, extension.toLowerCase());
			}
		});

		for (UIManager.LookAndFeelInfo lookAndFeelInfo : lookAndFeels) {
			JMenuItem item = new JMenuItem(lookAndFeelInfo.getName());
			item.addActionListener(event -> {
				try {
					UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
					SwingUtilities.updateComponentTreeUI(mainFrame);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			});
			lookMenu.add(item);
		}

		savePolygon.add(save);
		savePolygon.add(screenShoot);
		this.add(changeLineSize);
		this.add(savePolygon);
		this.add(lookMenu);
	}

}
