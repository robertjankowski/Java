package pl.java.lab2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CloseableFrame extends JFrame {

	public static final int WIDHT = 640;
	public static final int HEIGHT = 480;
	
	public CloseableFrame() throws HeadlessException{
		super("Hello");
		this.setSize(WIDHT,HEIGHT);
		setLayout(new FlowLayout());
		
		JButton b1 = new JButton("button");
		this.add(b1);
		JButton b2 = new JButton("drugi");
		b2.setPreferredSize(new Dimension(100,100));
		this.add(b2);
		JLabel l1 = new JLabel("To jest etykieta");
		this.add(l1);
		
		TextField tf = new TextField("sample text");
		this.add(tf);
		getContentPane().setBackground(Color.BLACK);
		//pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public CloseableFrame(GraphicsConfiguration gc) {
		super(gc);
		
	}

	public CloseableFrame(String title) throws HeadlessException {
		super(title);
	}

	public CloseableFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CloseableFrame();
			}
		});
	}

}
