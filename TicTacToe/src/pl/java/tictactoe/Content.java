package pl.java.tictactoe;

public enum Content {
	EMPTY(0), CIRCLE(1), CROSS(2);

	private int type;

	private Content(int type) {
		this.setType(type);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
