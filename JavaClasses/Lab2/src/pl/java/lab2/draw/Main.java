package pl.java.lab2.draw;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

	public Main() throws HeadlessException {
		super("Hello");
		this.setSize(1000,600);
		setLayout(new GridLayout(1,1));
		//setResizable(false);
		
		// pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Main main = new Main();
		
		JPanel panel1 = new JPanel(new GridLayout(4,1));
		panel1.add(new JButton("button 1"));
		panel1.add(new JButton("button 2"));
		panel1.add(new JButton("button 3"));
		panel1.add(new JButton("button 4"));
		
		
		DrawablePanel panel2 = new DrawablePanel();
		panel1.setBackground(Color.BLACK);
		
		panel2.show();
		panel2.go();
		panel2.repaint();
		
		main.add(panel1);
		main.add(panel2);
	}

}