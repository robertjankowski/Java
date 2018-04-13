package pl.java.lab5;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

	JLabel label;

	public BottomPanel() {
		label = new JLabel("line");
		label.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 20));
		this.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		this.add(label);
	}
}
