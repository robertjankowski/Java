package pl.java.lab3.comboBox;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

public class ComboBoxItemListener implements ItemListener {

	public JPanel panel;

	public ComboBoxItemListener(JPanel jPanel) {
		this.panel = jPanel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String color = (String) e.getItem();
			switch (color) {
			case "red":
				panel.setBackground(Color.red);
				break;
			case "green":
				panel.setBackground(Color.green);
				break;
			case "yellow":
				panel.setBackground(Color.yellow);
				break;
			case "blue":
				panel.setBackground(Color.blue);
				break;
			case "orange":
				panel.setBackground(Color.orange);
				break;
			}
		}
	}

}
