package pl.gameoflife;

public enum Quality {

	HIGH(1), MEDIUM(2), LOW(3);
	private final int divisor;

	private Quality(int divisor) {
		this.divisor = divisor;
	}

	int getDivisor() {
		return divisor;
	}

}
