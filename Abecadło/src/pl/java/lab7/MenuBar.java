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
	JMenu czcionkaRozmiar;
	JMenu czcionkaRodzaj;

	JMenuItem czcionkaRozmiarDuzy;
	JMenuItem czcionkaRozmiarMaly;
	JMenuItem czcionkaRozmiarNormalny;

	JMenuItem czcionkaRodzajNormalna;
	JMenuItem czcionkaRodzajItalic;
	JMenuItem czcionkaRodzajBold;

	public MenuBar() {
		plik = new JMenu("Plik");
		czcionka = new JMenu("Czcionka");

		plikNowy = new JMenuItem("Nowy");
		plikOtworz = new JMenuItem("Otwórz");
		plikZapisz = new JMenuItem("Zapisz");
		plikZakoncz = new JMenuItem("Zakończ");

		czcionkaKolor = new JMenuItem("Kolor");
		czcionkaRodzaj = new JMenu("Rodzaj");
		czcionkaRozmiar = new JMenu("Rozmiar");

		czcionkaRozmiarDuzy = new JMenuItem("Duża");
		czcionkaRozmiarMaly = new JMenuItem("Mała");
		czcionkaRozmiarNormalny = new JMenuItem("Normalna");

		czcionkaRodzajNormalna = new JMenuItem("Normalna");
		czcionkaRodzajItalic = new JMenuItem("Kusywa");
		czcionkaRodzajBold = new JMenuItem("Pogrubiona");

		plik.add(plikNowy);
		plik.add(plikOtworz);
		plik.add(plikZapisz);
		plik.addSeparator();
		plik.add(plikZakoncz);

		czcionkaRozmiar.add(czcionkaRozmiarDuzy);
		czcionkaRozmiar.add(czcionkaRozmiarNormalny);
		czcionkaRozmiar.add(czcionkaRozmiarMaly);

		czcionkaRodzaj.add(czcionkaRodzajBold);
		czcionkaRodzaj.add(czcionkaRodzajItalic);
		czcionkaRodzaj.add(czcionkaRodzajNormalna);

		czcionka.add(czcionkaKolor);
		czcionka.add(czcionkaRozmiar);
		czcionka.add(czcionkaRodzaj);

		this.add(plik);
		this.add(czcionka);

	}

}
