package pl.java.lab4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

	JButton bgColor;
	JButton lnColor;
	JColorChooser bcolorChooser;
	JColorChooser lcolorChooser;

	public BottomPanel() {
		bgColor = new JButton("BG COLOR");
		lnColor = new JButton("LN COLOR");
		bcolorChooser = new JColorChooser();
		lcolorChooser = new JColorChooser();
		this.setLayout(new FlowLayout());
		this.add(bgColor);
		this.add(lnColor);
	}

}
