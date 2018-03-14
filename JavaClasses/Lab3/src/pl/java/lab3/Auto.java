package pl.java.lab3;

public class Auto implements Pojazd {

	double[] predkosc;

	public Auto() {
		predkosc = new double[3];
	}

	@Override
	public void start() {

	}

	@Override
	public void stop() {

	}

	@Override
	public void ustawPredkosc(double[] v) {
		if (v.length >= 3) {
			predkosc[0] = v[0];
			predkosc[1] = v[1];
			predkosc[2] = v[2];
		}
	}
	
	@Override
	public String nazwa() {
		return Pojazd.super.nazwa() + " Auto";
	}
	
	public static void main(String[] args) {
		Pojazd p1 = new Auto();
		System.out.println(p1.nazwa());
		System.out.println(p1.obliczPredkosc(20, 2021.3f));
	}
}
