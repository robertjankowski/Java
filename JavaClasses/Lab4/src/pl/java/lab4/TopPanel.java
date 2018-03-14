package pl.java.lab4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TopPanel extends JPanel {

	JSlider slider;
	JButton drawButton;
	JLabel label;
	public static int vertices;
	public static int MAX_VERTICES = 33;
	public static int START_VERTICES = 4;

	public TopPanel() {
		slider = new JSlider(JSlider.HORIZONTAL, 3, MAX_VERTICES, START_VERTICES);
		slider.setMajorTickSpacing((MAX_VERTICES - START_VERTICES) / 2);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		drawButton = new JButton("Draw");
		label = new JLabel("No. of vertices");
		Border border = BorderFactory.createLineBorder(Color.GREEN);
		this.setBorder(border);
		this.setLayout(new FlowLayout());
		vertices = slider.getValue();

		this.add(label);
		this.add(slider);
		this.add(drawButton);
	}

}
