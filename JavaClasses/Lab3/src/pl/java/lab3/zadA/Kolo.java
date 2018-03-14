package pl.java.lab3.zadA;

public class Kolo implements Figura {

	private double promien;

	public Kolo(double promien) {
		this.promien = promien;
	}

	@Override
	public double obliczObwod() {
		return PI * promien * 2;
	}

	@Override
	public double obliczPole() {
		return PI * promien * promien;
	}

}
