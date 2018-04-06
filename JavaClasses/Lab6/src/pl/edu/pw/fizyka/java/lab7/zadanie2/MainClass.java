package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {

	public static int width = 600;
	public static int height = 600;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame f = new JFrame("Prostokaty");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PanelRysowania panel = new PanelRysowania();

			panel.dodajProstokat(100, 100, 80, 160, Color.BLUE);

			for (int i = 1; i < 20; i++)
				panel.dodajLosowyProstokat();

			new Thread(panel).start();

			f.add(panel);
			f.setSize(width, height);
			f.setVisible(true);
		});

	}

}
