package pl.java.lab5;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuListener implements ActionListener {

	MenuBar menuBar;
	DrawPanel drawPanel;

	public MenuListener(MenuBar menuBar, DrawPanel drawPanel) {
		this.menuBar = menuBar;
		this.drawPanel = drawPanel;
		menuBar.aboutHelp.addActionListener(this);
		menuBar.editBGColors.addActionListener(this);
		menuBar.editLNColors.addActionListener(this);
		menuBar.resetColors.addActionListener(this);
		menuBar.line1px.addActionListener(this);
		menuBar.line2px.addActionListener(this);
		menuBar.line5px.addActionListener(this);
		menuBar.line10px.addActionListener(this);
		menuBar.newFile.addActionListener(this);
		menuBar.saveFile.addActionListener(this);
		menuBar.openFile.addActionListener(this);
		menuBar.rotateImage.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == menuBar.aboutHelp) {
			JOptionPane.showMessageDialog(null, "Click on the tool button and draw :)");
		}
		if (ob == menuBar.editBGColors) {
			Color color = JColorChooser.showDialog(null, "Change background color", Color.WHITE);
			if (color != null) {
				Constants.setBgColor(color);
				drawPanel.setBackground(color);
			}
		}
		if (ob == menuBar.editLNColors) {
			Color color = JColorChooser.showDialog(null, "Change line color", Color.BLACK);
			if (color != null) {
				Constants.setLnColor(color);
			}
			drawPanel.repaint();
		}
		if (ob == menuBar.resetColors) {
			resetColor(drawPanel);
		}
		if (ob == menuBar.line1px) {
			Constants.setLineWidth(1);
		}
		if (ob == menuBar.line2px) {
			Constants.setLineWidth(2);
		}
		if (ob == menuBar.line5px) {
			Constants.setLineWidth(5);
		}
		if (ob == menuBar.line10px) {
			Constants.setLineWidth(10);
		}
		if (ob == menuBar.newFile) {
			newFile(drawPanel);
		}
		if (ob == menuBar.saveFile) {
			saveToFile(drawPanel);
		}
		if (ob == menuBar.openFile) {
			openFile(drawPanel);
		}
		if(ob == menuBar.rotateImage) {
			rotatePanel(drawPanel);
		}

	}

	public static void resetColor(DrawPanel drawPanel) {
		drawPanel.shapes.clear();
		drawPanel.shape = null;
		drawPanel.image = null;
		drawPanel.repaint();
	}

	public void rotatePanel(DrawPanel drawPanel) {
		BufferedImage image = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.rotate(Math.PI/4, image.getWidth()/2, image.getHeight()/2);
		drawPanel.paintAll(g2d);
		resetColor(drawPanel);
		drawPanel.setBackgroudImage(image);
		
	}
	
	public void newFile(DrawPanel drawPanel) {
		int save = JOptionPane.showConfirmDialog(drawPanel, "Do you want to save a file?", "New file",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// yes - 0 no - 1 cancel - 2
		if (save == 1) {
			resetColor(drawPanel);
		}
		if (save == 0) {
			saveToFile(drawPanel);
		}
	}

	public void saveToFile(DrawPanel drawPanel) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showDialog(null, "Save");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			BufferedImage image = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(),
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = image.createGraphics();
			drawPanel.paintAll(g2d);
			try {
				ImageIO.write(image, "png", fc.getSelectedFile());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public void openFile(DrawPanel drawPanel) {
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Graphic files", "jpg","gif","png");
		fc.addChoosableFileFilter(filter);
		int returnVal = fc.showDialog(null, "Open");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			BufferedImage image = null;
			try {
				image = ImageIO.read(fc.getSelectedFile());
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
			drawPanel.setBackgroudImage(image);
		}
	}

}
