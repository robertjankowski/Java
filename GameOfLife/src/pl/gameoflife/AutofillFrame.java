package pl.gameoflife;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AutofillFrame extends JFrame {

	private static final long serialVersionUID = 8773408848597294969L;
	GameBoard gameBoard;
	JPanel percentPanel;

	public AutofillFrame(GameBoard gameBoard) {
		super("Autofill options");
		this.setSize(360, 60);
		this.gameBoard = gameBoard;
		this.setVisible(true);
		this.setLocationRelativeTo(gameBoard);
		percentPanel = new JPanel();
		percentPanel.setOpaque(false);
		percentPanel.add(new JLabel("What percent would you like to be filled ? "));
		Object[] percentOptions = { "Select", 5, 10, 15, 20, 30, 40, 50, 60, 70, 80, 90 };
		JComboBox<Object> comboOptions = new JComboBox<>(percentOptions);
		percentPanel.add(comboOptions);
		comboOptions.addActionListener(e -> {
			if (comboOptions.getSelectedIndex() > 0) {
				gameBoard.resetBoard();
				gameBoard.randomlyFillBoard((Integer) comboOptions.getSelectedIndex());
				this.setVisible(false);
			}
		});
		this.add(percentPanel);
	}
}
