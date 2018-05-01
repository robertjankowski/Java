package pl.java.lab4;

import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;

public class MenuListener implements ActionListener {

	CenterPanel centerPanel;
	Menu menu;

	public MenuListener(CenterPanel centerPanel, Menu menu) {
		this.centerPanel = centerPanel;
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu.line1px) {
			centerPanel.stroke = new BasicStroke(1);
		} else if (e.getSource() == menu.line5px) {
			centerPanel.stroke = new BasicStroke(5);
		} else if (e.getSource() == menu.line10px) {
			centerPanel.stroke = new BasicStroke(10);
		}
		centerPanel.g2d.setStroke(centerPanel.stroke);
		centerPanel.repaint();
	}
}
