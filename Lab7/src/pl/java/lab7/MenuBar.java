package pl.java.lab7;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	JMenu plik;
	JMenu czcionka;

	JMenuItem plikNowy;
	JMenuItem plikOtworz;
	JMenuItem plikZapisz;
	JMenuItem plikZakoncz;

	JMenuItem czcionkaKolor;
	JMenuItem czcionkaRozmiar;
	JMenuItem czcionkaRodzaj;

	public MenuBar() {
		plik = new JMenu("Plik");
		czcionka = new JMenu("Czcinka");

		plikNowy = new JMenuItem("Nowy");
		plikOtworz = new JMenuItem("Otwórz");
		plikZapisz = new JMenuItem("Zapisz");
		plikZakoncz = new JMenuItem("Zakończ");

		czcionkaKolor = new JMenuItem("Kolor");
		czcionkaRodzaj = new JMenuItem("Rodzaj");
		czcionkaRozmiar = new JMenuItem("Rozmiar");

		plik.add(plikNowy);
		plik.add(plikOtworz);
		plik.add(plikZapisz);
		plik.addSeparator();
		plik.add(plikZakoncz);

		czcionka.add(czcionkaKolor);
		czcionka.add(czcionkaRozmiar);
		czcionka.add(czcionkaRodzaj);

		this.add(plik);
		this.add(czcionka);

	}

}
