package pl.randomwalk.custompoint;

import java.awt.Color;

public class Preferences {

	static Color POINT_COLOR = Color.BLACK;
	public static int BLOCK_SIZE = 15;
	public static int UP = 0;
	public static int DOWN = 0;

	public static Color getPOINT_COLOR() {
		return POINT_COLOR;
	}

	public static void setPOINT_COLOR(Color pOINT_COLOR) {
		POINT_COLOR = pOINT_COLOR;
	}

}
