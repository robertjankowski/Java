package pl.gameoflife;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimePeriodFrame extends JFrame {

	private static final long serialVersionUID = -6889467531711521597L;
	GameBoard gameBoard;
	JPanel percentPanel;

	public TimePeriodFrame(GameBoard gameBoard) {
		super("Time options");
		this.gameBoard = gameBoard;
		this.setSize(360, 60);
		this.setVisible(true);
		this.setLocationRelativeTo(gameBoard);
		percentPanel = new JPanel();
		percentPanel.setOpaque(false);
		percentPanel.add(new JLabel("Choose time period"));
		Object[] percentOptions = { "Select", 1, 2, 5, 10, 20, 50 };
		JComboBox<Object> comboOptions = new JComboBox<>(percentOptions);
		percentPanel.add(comboOptions);
		comboOptions.addActionListener(e -> {
			if (comboOptions.getSelectedIndex() > 0) {
				GameBoard.TIME_PERIOD = (Integer) comboOptions.getSelectedIndex();
				this.setVisible(false);
			}
		});
		this.add(percentPanel);
	}
}
