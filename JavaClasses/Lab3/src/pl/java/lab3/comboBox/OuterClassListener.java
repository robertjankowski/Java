package pl.java.lab3.comboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OuterClassListener extends JFrame {

	public OuterClassListener() {
		super("JComboBox");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);

		String[] colors = { "red", "green", "blue", "yellow", "orange" };
		JComboBox<String> colorList = new JComboBox<>(colors);
		this.add(colorList, BorderLayout.PAGE_START);
		this.getContentPane().setBackground(Color.red);
		colorList.addItemListener(new ComboBoxItemListener((JPanel)this.getContentPane()));
	}

	public static void main(String[] args) {
		new OuterClassListener().setVisible(true);
	}

}
