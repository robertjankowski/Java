package pl.java.lab3;

public interface Pojazd {

	public void start();
	public void stop();
	public void ustawPredkosc(double[] v);
	default String nazwa() {
		return "Pojazd";
	}
	default float obliczPredkosc(float s,float t) {
		return s*t;
	}
	
}
