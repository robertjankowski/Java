package pl.java.lab3.zadA;

public class Trojkat implements Figura {

	private double bok1;
	private double bok2;
	private double bok3;

	public Trojkat(double bok1, double bok2, double bok3) {
		this.bok1 = bok1;
		this.bok2 = bok2;
		this.bok3 = bok3;
	}

	@Override
	public double obliczObwod() {
		return bok1+bok2+bok3;
	}

	@Override
	public double obliczPole() {
		double tmp = obliczObwod()/2;
		return Math.sqrt(tmp*(tmp-bok1)*(tmp-bok2)*(tmp-bok3));
	}

}
