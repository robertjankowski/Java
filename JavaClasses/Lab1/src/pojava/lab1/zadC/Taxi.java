package pojava.lab1.zadC;

import java.util.Random;

public class Taxi extends Auto {

	public Taxi() {
		super();
		zarobki = new float[12];
		Random r = new Random();
		for (int i = 0; i < zarobki.length; i++) {
			zarobki[i] = r.nextFloat()*1000;
		}
	}

	public float srZarobki() {
		float suma = 0;
		for (int i = 0; i < zarobki.length; i++) {
			suma += zarobki[i];
		}
		return suma / zarobki.length;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < zarobki.length; i++) {
			s += " \n" + zarobki[i];
		}
		return s;
	}

	public static void main(String[] args) {
		Taxi t1 = new Taxi();
		System.out.println(t1);
		System.out.println("Srednie zarobki: " + t1.srZarobki());
	}

	private float[] zarobki;
}
