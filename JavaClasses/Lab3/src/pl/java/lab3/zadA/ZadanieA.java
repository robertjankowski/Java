package pl.java.lab3.zadA;

public class ZadanieA {

	public static void main(String[] args) {
		Figura f1 = new Kolo(3);
		System.out.println(f1.obliczObwod() + " " + f1.obliczPole());
		f1 = new Trojkat(3, 4, 5);
		System.out.println(f1.obliczObwod() + " " + f1.obliczPole());
		
	}

}
