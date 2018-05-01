package pojava.lab1.zadC;

public class Auto {

	
	public Auto() {
		przebieg = new float[12];
	}
	public float srPrzebieg() {
		float suma = 0;
		for(int i=0; i<przebieg.length; i++) {
			suma += przebieg[i];
		}
		return suma/przebieg.length;
	}
	@Override
	public String toString() {
		String s="";
		for (int i = 0; i < przebieg.length; i++) {
			s += "" + przebieg[i];
		}
		return s;
	}
	
	private float[] przebieg;
}
