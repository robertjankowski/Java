package pl.java.lab7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

	JButton sprawdz;

	public BottomPanel(EditorPanel editorPanel) {
		sprawdz = new JButton("Sprawdź pisownię");
		this.add(sprawdz);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		sprawdz.addActionListener(e -> {
			String[] tab = editorPanel.textPane.getText().split(" ");
			List<String> inCorrect = new ArrayList<>();
			List<String> correct = new ArrayList<>();
			boolean isCorrect = true;
			for (int i = 0; i < tab.length; i++) {
				if (!tab[i].equals(editorPanel.checkList.get(i))) {
					isCorrect = false;
					inCorrect.add(tab[i]);
				} else {
					correct.add(tab[i]);
				}
			}
			if (isCorrect) {
				JOptionPane.showMessageDialog(null, "Gratulacje", "Koniec", JOptionPane.INFORMATION_MESSAGE);
			}
			JFrame frame = new JFrame("Rezultat");
			frame.setLayout(new GridLayout(1, 2));
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			panel1.setBorder(
					BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Niepoprawne słowa"));
			panel2.setBorder(
					BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Poprawne słowa"));
			panel1.setLayout(new GridLayout(inCorrect.size(), 1));
			panel2.setLayout(new GridLayout(correct.size(), 1));
			JLabel[] correctLabels = new JLabel[correct.size()];
			JLabel[] incorrectLabels = new JLabel[inCorrect.size()];
			for (int i = 0; i < inCorrect.size(); i++) {
				incorrectLabels[i] = new JLabel();
				incorrectLabels[i].setText(inCorrect.get(i));
				panel1.add(incorrectLabels[i]);
			}
			for (int i = 0; i < correct.size(); i++) {
				correctLabels[i] = new JLabel();
				correctLabels[i].setText(correct.get(i));
				panel2.add(correctLabels[i]);
			}
			frame.setPreferredSize(new Dimension(400, 400));
			frame.setLocationRelativeTo(null);
			frame.add(panel1);
			frame.add(panel2);
			frame.pack();
			frame.setVisible(true);
		});
	}

}
