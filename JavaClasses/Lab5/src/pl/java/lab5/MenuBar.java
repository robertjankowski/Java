package pl.java.lab5;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	JMenu file;
	JMenu lineWidth;
	JMenu view;
	JMenu image;
	JMenu colors;
	JMenu help;

	JMenuItem newFile;
	JMenuItem openFile;
	JMenuItem saveFile;

	JMenuItem line1px;
	JMenuItem line2px;
	JMenuItem line5px;
	JMenuItem line10px;

	JMenuItem zoomView;

	JMenuItem rotateImage;

	JMenuItem editBGColors;
	JMenuItem editLNColors;
	JMenuItem resetColors;

	JMenuItem aboutHelp;

	public MenuBar() {
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		lineWidth = new JMenu("Line width");
		lineWidth.setMnemonic(KeyEvent.VK_L);
		view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);
		image = new JMenu("Image");
		image.setMnemonic(KeyEvent.VK_I);
		colors = new JMenu("Colors");
		colors.setMnemonic(KeyEvent.VK_C);
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);

		newFile = new JMenuItem("New");
		openFile = new JMenuItem("Open...");
		saveFile = new JMenuItem("Save");
		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);

		line1px = new JMenuItem("1 px");
		line2px = new JMenuItem("2 px");
		line5px = new JMenuItem("5 px");
		line10px = new JMenuItem("10 px");
		lineWidth.add(line1px);
		lineWidth.add(line2px);
		lineWidth.add(line5px);
		lineWidth.add(line10px);

		zoomView = new JMenuItem("Zoom");
		view.add(zoomView);

		rotateImage = new JMenuItem("Rotate");
		image.add(rotateImage);

		editBGColors = new JMenuItem("Edit background color");
		editLNColors = new JMenuItem("Edit line color");
		resetColors = new JMenuItem("Reset");
		colors.add(editBGColors);
		colors.add(editLNColors);
		colors.add(resetColors);

		aboutHelp = new JMenuItem("About");
		help.add(aboutHelp);

		this.add(file);
		this.add(lineWidth);
		this.add(image);
		this.add(colors);
		this.add(help);
	}

}
