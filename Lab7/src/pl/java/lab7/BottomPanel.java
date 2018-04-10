package pl.java.lab7;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

	JButton sprawdz;

	public BottomPanel() {
		sprawdz = new JButton("Sprawdź pisownię");
		this.add(sprawdz);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}

}
