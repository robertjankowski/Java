package pl.java.lab3.zadB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ButtonListener implements ActionListener {

	private JFrame frame;
	byte counter = 0;

	public ButtonListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setTitle("You clicked on button " + counter + " times");
		counter++;
		frame.requestFocus();
	}

}
