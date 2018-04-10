package pl.java.lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MenuListener implements ActionListener {

	MenuBar menuBar;
	EditorPanel editorPanel;

	public MenuListener(MenuBar menuBar, EditorPanel editorPanel) {
		this.menuBar = menuBar;
		this.editorPanel = editorPanel;
		this.menuBar.plikNowy.addActionListener(this);
		this.menuBar.plikOtworz.addActionListener(this);
		this.menuBar.plikZapisz.addActionListener(this);
		this.menuBar.plikZakoncz.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(menuBar.plikNowy)) {
			int save = JOptionPane.showConfirmDialog(editorPanel, "Czy chcesz zapisać plik ?", "Nowy plik",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			// yes - 0 no - 1 cancel - 2
			if (save == 1) {
				editorPanel.textPane.setText("");
			}
			if (save == 0) {
				// save
			}
		}
		if (o.equals(menuBar.plikOtworz)) {

		}
		if (o.equals(menuBar.plikZapisz)) {

		}
		if (o.equals(menuBar.plikZakoncz)) {
			int exit = JOptionPane.showConfirmDialog(editorPanel, "Czy chcesz zapisać plik ?", "Zakończ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			// yes - 0 no - 1 cancel - 2
			if (exit == 1) {
				System.exit(0);
			}
			if (exit == 0) {
				// save !
			}
		}
	}

}
