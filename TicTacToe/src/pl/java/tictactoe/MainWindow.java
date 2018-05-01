package pl.java.tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener {

	public MainWindow(String nameWindow) {
		super(nameWindow);
		setResizable(false);
		main.setLayout(new BorderLayout());
		panel1.setLayout(new GridLayout(3, 3));
		panel2.setLayout(new GridLayout(1, 2));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new DrawableButton(WIDTH / 10, HEIGHT / 10);
				buttons[i][j].addActionListener(this);
				panel1.add(buttons[i][j]);
			}
		}
		n1 = JOptionPane.showInputDialog("Please enter your name 1");
		name1.setText(n1 + " :" + score1);
		name1.setFont(new Font(n1, Font.BOLD, 40));
		name1.setBorder(border);
		n2 = JOptionPane.showInputDialog("Please enter your name 2");
		name2.setText(n2 + " :" + score2);
		name2.setFont(new Font(n2, Font.BOLD, 40));
		panel2.add(name1);
		panel2.add(name2);

		main.add(panel2, BorderLayout.NORTH);
		main.add(panel1, BorderLayout.CENTER);
		add(main);
		setSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Content tmp = Content.CIRCLE;
		counter++;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (e.getSource() == buttons[i][j]) {
					buttons[i][j].draw();
					buttons[i][j].setEnabled(false);
					tmp = buttons[i][j].getContent();
				}
			}
		}
		if (tmp.equals(Content.CIRCLE)) {
			name2.setBorder(border);
			name1.setBorder(null);
		} else if (tmp.equals(Content.CROSS)) {
			name1.setBorder(border);
			name2.setBorder(null);
		}
		if (checkWin(tmp)) {
			int choice = 9999;
			if (tmp.equals(Content.CIRCLE)) {
				choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?",
						name1.getText().substring(0, name1.getText().length() - 3) + " won !",
						JOptionPane.YES_NO_OPTION);
			} else if (tmp.equals(Content.CROSS)) {
				choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?",
						name2.getText().substring(0, name2.getText().length() - 3) + " won !",
						JOptionPane.YES_NO_OPTION);
			}
			/**
			 * yes = 0, no = 1
			 */
			if (choice == 0) {
				reset();
				if (tmp.equals(Content.CIRCLE)) {
					score1++;
					name1.setText(n1 + " : " + score1);
				} else if (tmp.equals(Content.CROSS)) {
					score2++;
					name2.setText(n2 + " : " + score2);
				}
			} else if (choice == 1) {
				System.exit(0);
			}
		} else if (counter == 9) {
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Draw",
					JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				reset();
			} else if (choice == 1) {
				System.exit(0);
			}
		}
	}

	private boolean checkWin(Content c) {
		boolean win = false;
		for (int i = 0; i < 3; i++) {
			if (buttons[0][i].getContent() == c && buttons[1][i].getContent() == c && buttons[2][i].getContent() == c) {
				win = true;
			}
			if (buttons[i][0].getContent() == c && buttons[i][1].getContent() == c && buttons[i][2].getContent() == c) {
				win = true;
			}
		}
		if (buttons[0][0].getContent() == c && buttons[1][1].getContent() == c && buttons[2][2].getContent() == c) {
			win = true;
		}
		if (buttons[0][2].getContent() == c && buttons[1][1].getContent() == c && buttons[2][0].getContent() == c) {
			win = true;
		}
		return win;
	}

	private void reset() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j].setContent(Content.EMPTY);
				buttons[i][j].setIcon(null);
				buttons[i][j].setEnabled(true);
				DrawablePanel.moveCount = 0;
			}
		}
		counter = 0;
	}

	private final int WIDTH = 800;
	private final int HEIGHT = 800;

	private DrawableButton[][] buttons = new DrawableButton[3][3];

	private JPanel main = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JLabel name1 = new JLabel();
	private JLabel name2 = new JLabel();
	Border border = BorderFactory.createLineBorder(Color.RED, 5);

	private int score1 = 0;
	private int score2 = 0;

	private String n1 = "";
	private String n2 = "";

	private byte counter = 0;

}
