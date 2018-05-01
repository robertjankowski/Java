package pl.java.lab3.zadC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MedianFrame extends JFrame implements ActionListener{

	public MedianFrame() {
		setLocationRelativeTo(null);
		setSize(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		numbers = new ArrayList<>();
		mainPanel = new JPanel(new GridLayout(2, 1));
		topPanel = new JPanel(new FlowLayout());
		bottomPanel = new JPanel(new BorderLayout());
		textField = new JTextField("", 20);
		add = new JButton("Dodaj");
		median = new JButton("Mediana");
		score = new JLabel("Wynik");
		allNumbers = new JLabel("Zbiór liczb: ");

		add.addActionListener(this);
		median.addActionListener(this);

		topPanel.add(textField);
		topPanel.add(add);
		topPanel.add(median);
		topPanel.add(score);

		bottomPanel.add(allNumbers);

		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		this.add(mainPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			try {
				number = Double.parseDouble(textField.getText());
				numbers.add(number);
				// System.out.println(numbers);
				allNumbers.setText("Zbiór liczb: " + numbers.toString());
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		if (e.getSource() == median) {
			double tmp = 0;
			int pos;
			int pos2;
			Collections.sort(numbers);
			allNumbers.setText("Zbiór liczb: " + numbers.toString());
			System.out.println(numbers.size());
			if (numbers.size() % 2 == 0) {
				pos = numbers.size()/2-1;
				pos2 = numbers.size()/2;
				tmp = (numbers.get(pos)+numbers.get(pos2))/2;
			} else {
				pos = (numbers.size() / 2);
				tmp = numbers.get(pos);
			}
			score.setText("= " + tmp);

		}

	}

	public static void main(String[] args) {
		new MedianFrame().setVisible(true);
	}
	
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JTextField textField;
	private JButton add;
	private JButton median;
	private JLabel score;
	private JLabel allNumbers;
	private double number;
	List<Double> numbers;


}
