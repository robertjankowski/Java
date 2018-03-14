package pl.java.lab4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class LeftPanel extends JPanel {

	String mode;
	public static final String REGULAR = "REGULAR";
	public static final String RANDOM = "RANDOM";
	JRadioButton regular;
	JRadioButton random;

	public LeftPanel() {
		this.mode = REGULAR;
		regular = new JRadioButton("Regular");
		random = new JRadioButton("Random");
		random.setActionCommand(RANDOM);
		regular.setSelected(true);
		regular.setActionCommand(REGULAR);
		ButtonGroup group = new ButtonGroup();
		this.setLayout(new GridLayout(2, 1));
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Polygon");
		group.add(regular);
		group.add(random);
		this.add(regular);
		this.add(random);
		this.setBorder(border);
	}

	public String getMode() {
		return mode;
	}

}
