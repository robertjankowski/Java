package pl.java.lab2.zadC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreeButtonFrame extends JFrame implements ActionListener {

	private Random r = new Random();
	private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);
	int counter = 1;
	
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JPanel panel;

	public ThreeButtonFrame() {
		super("Three button");
		setLayout(new GridLayout(1,1));
		setSize(new Dimension(800, 600));

		panel = new JPanel();

		b1 = new JButton("Zakoncz");
		b2 = new JButton("Zmien tekst");
		b3 = new JButton("Zmien kolor");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setBackground(Color.BLACK);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.setBackground(Color.BLUE);
		this.add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == b1) {
			System.exit(0);
		}
		if (ob == b2) {
			if (counter %2 == 0) {
				b2.setText("Nacisnieto");
			} 
			else { 
				b2.setText("Inny tekst");
			}
			counter++;
			
		}
		if (ob == b3) {
			red = r.nextInt(255);
			green = r.nextInt(255);
			blue = r.nextInt(255);
			b3.setBackground(new Color(red, green, blue));

		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ThreeButtonFrame();
			}
		});

	}

}
