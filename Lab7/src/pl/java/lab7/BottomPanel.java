package pl.java.lab7;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
				// komunikat ze wszystko jest okej !
			}
			// teraz ustawić obok siebie dwa panele, border i tam napis poprawne plus slowa 
			JFrame frame = new JFrame("Rezultat");
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JLabel[] labels = new JLabel[inCorrect.size()];
			StringBuilder all = new StringBuilder();
			for (int i = 0; i < inCorrect.size(); i++) {
				labels[i] = new JLabel();
				labels[i].setText(inCorrect.get(i));
			}
			System.out.println(all.toString());
			for (JLabel l : labels) {
				panel1.add(l);
			}
			frame.setPreferredSize(new Dimension(300, 300));
			frame.setLocationRelativeTo(null);
			frame.add(panel1);
			// frame.add(panel2);
			frame.pack();
			frame.setVisible(true);
		});
	}

}
