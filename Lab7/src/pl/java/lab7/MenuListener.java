package pl.java.lab7;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class MenuListener implements ActionListener {

	MenuBar menuBar;
	EditorPanel editorPanel;
	int currentFontSize = Preferences.FONT_NORMAL;
	int currentFontStyle = Font.PLAIN;

	public MenuListener(MenuBar menuBar, EditorPanel editorPanel) {
		this.menuBar = menuBar;
		this.editorPanel = editorPanel;
		this.menuBar.plikNowy.addActionListener(this);
		this.menuBar.plikOtworz.addActionListener(this);
		this.menuBar.plikZapisz.addActionListener(this);
		this.menuBar.plikZakoncz.addActionListener(this);
		this.menuBar.czcionkaKolor.addActionListener(this);
		this.menuBar.czcionkaRodzaj.addActionListener(this);
		this.menuBar.czcionkaRozmiarDuzy.addActionListener(this);
		this.menuBar.czcionkaRozmiarMaly.addActionListener(this);
		this.menuBar.czcionkaRozmiarNormalny.addActionListener(this);
		this.menuBar.czcionkaRodzajBold.addActionListener(this);
		this.menuBar.czcionkaRodzajItalic.addActionListener(this);
		this.menuBar.czcionkaRodzajNormalna.addActionListener(this);
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
		if (o.equals(menuBar.czcionkaKolor)) {
			Color color = JColorChooser.showDialog(null, "Zmień kolor czcionki", Color.BLACK);
			editorPanel.changeColor(editorPanel.textPane, "Dziala ?", color);
		}
		if (o.equals(menuBar.czcionkaRozmiarDuzy)) {
			currentFontSize = Preferences.FONT_LARGE;
			editorPanel.textPane.setFont(new Font("Serif", currentFontStyle, currentFontSize));
		}
		if (o.equals(menuBar.czcionkaRozmiarMaly)) {
			currentFontSize = Preferences.FONT_SMALL;
			editorPanel.textPane.setFont(new Font("Serif", currentFontStyle, currentFontSize));
		}
		if (o.equals(menuBar.czcionkaRozmiarNormalny)) {
			currentFontSize = Preferences.FONT_NORMAL;
			editorPanel.textPane.setFont(new Font("Serif", currentFontStyle, currentFontSize));
		}
		if (o.equals(menuBar.czcionkaRodzajBold)) {
			currentFontStyle = Font.BOLD;
			editorPanel.textPane.setFont(new Font("Serif", currentFontStyle, currentFontSize));
		}
		if (o.equals(menuBar.czcionkaRodzajItalic)) {
			currentFontStyle = Font.ITALIC;
			editorPanel.textPane.setFont(new Font("Serif", currentFontStyle, currentFontSize));
		}
		if (o.equals(menuBar.czcionkaRodzajNormalna)) {
			currentFontStyle = Font.PLAIN;
			editorPanel.textPane.setFont(new Font("Serif", currentFontStyle, currentFontSize));
		}

	}

}
