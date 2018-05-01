package pl.java.lab2.przyklad3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example2 extends JFrame {

	public Example2() throws HeadlessException {
		super("Hello");
		this.setSize(640, 480);
		setLayout(new GridLayout(2,2));
		setResizable(false);
		JPanel panel1 = new JPanel(new FlowLayout());
		
		JButton b1 = new JButton("button");
		JButton b2 = new JButton("drugi");
		b2.setPreferredSize(new Dimension(100, 100));
		panel1.setBackground(Color.BLUE);
		panel1.add(b1);
		panel1.add(b2);
		
		JPanel panel2 = new JPanel(new GridLayout(2,2));
		panel2.add(new JLabel("1 label"));
		panel2.add(new JLabel("2 label"));
		panel2.add(new JLabel("3 label"));
		panel2.add(new JLabel("4 label"));
		
		
		
		//TextField tf = new TextField("sample text");
		//this.add(tf);
		getContentPane().setBackground(Color.BLACK);
		this.add(panel1);
		this.add(panel2);
		// pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public Example2(GraphicsConfiguration gc) {
		super(gc);
	}

	public Example2(String title) throws HeadlessException {
		super(title);
	}

	public Example2(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Example2();
				
			}
		});
	}

}

