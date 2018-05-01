package pl.java.lab3.zadB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MultiListenerFrame extends JFrame implements ChangeListener, KeyListener {

	public MultiListenerFrame() {
		this.setTitle(this.getClass().getName());
		this.setSize(600, 600);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addKeyListener(this);
		mainPanel = new JPanel(new GridLayout(2, 1));
		secondPanel = new JPanel(new FlowLayout());
		thirdPanel = new JPanel(new BorderLayout());
		thirdPanel.setBackground(Color.CYAN);
		progressPanel = new JPanel(new BorderLayout());
		String text = JOptionPane.showInputDialog("Please input a value");
		textField = new JTextField(text);
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setToolTipText("Change button text");
		slider.setMajorTickSpacing(10);
		slider.setSnapToTicks(true);
		button = new JButton("Change background");
		button2 = new JButton("Counter");
		label = new JLabel("Exit");
		label.setFont(new Font(label.getName(), Font.BOLD, 30));
		progressLabel = new JLabel("Click me");
		progressLabel.setFont(new Font("Click me", Font.ITALIC, 30));
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		Border border = BorderFactory.createTitledBorder("Reading...");
		progressBar.setBorder(border);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				secondPanel.setBackground(
						new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
				button.setText("Change background");
				requestFocus();
			}
		});
		buttonListener = new ButtonListener(this);
		button2.addActionListener(buttonListener);
		slider.addChangeListener(this);
		textField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		textField.addMouseListener(new LabelListener());
		//textField.setEditable(false);
		label.addMouseListener(new LabelListener());
		progressPanel.addMouseListener(new LabelListener());

		progressPanel.add(progressLabel, BorderLayout.PAGE_END);
		progressPanel.add(progressBar, BorderLayout.PAGE_START);
		
		secondPanel.add(button2);
		secondPanel.add(button);
		secondPanel.add(slider);
		thirdPanel.add(textField, BorderLayout.PAGE_START);
		thirdPanel.add(progressPanel, BorderLayout.CENTER);
		thirdPanel.add(label, BorderLayout.PAGE_END);

		mainPanel.add(secondPanel);
		mainPanel.add(thirdPanel);
		this.add(mainPanel);
		this.setFocusable(true);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			if (source.getValue() > 50) {
				button.setText("Hello");
			} else {
				button.setText("It's me !");
			}
		}
		this.requestFocus();
	}

	private class LabelListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == progressPanel) {
				counter++;
				progressBar.setValue(counter);
			}
			MultiListenerFrame.this.requestFocus();
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getSource() == label) {
				System.exit(0);
			}
			if (e.getSource() == textField) {
				System.out.println(textField.getText());
			}
			MultiListenerFrame.this.requestFocus();
		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == 's') {
			if (counter >= 1) {
				counter--;
				progressBar.setValue(counter);
				this.setFocusable(true);
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MultiListenerFrame().setVisible(true);
			}
		});
	}

	private JPanel mainPanel;
	private JPanel secondPanel;
	private JPanel thirdPanel;
	private JPanel progressPanel;
	private JButton button;
	private JButton button2;
	private JTextField textField;
	private JSlider slider;
	private JLabel label;
	private JLabel progressLabel;
	private JProgressBar progressBar;
	private byte counter = 0;
	private ButtonListener buttonListener;

}
