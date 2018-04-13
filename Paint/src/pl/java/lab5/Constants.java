package pl.java.lab5;

import java.awt.Color;

public class Constants {

	static Color lnColor = Color.BLACK;
	static Color bgColor = Color.WHITE;
	static int lineWidth = 1;

	public static Color getLnColor() {
		return lnColor;
	}

	public static void setLnColor(Color lnColor) {
		Constants.lnColor = lnColor;
	}

	public static Color getBgColor() {
		return bgColor;
	}

	public static void setBgColor(Color bgColor) {
		Constants.bgColor = bgColor;
	}

	public static int getLineWidth() {
		return lineWidth;
	}

	public static void setLineWidth(int lineWidth) {
		Constants.lineWidth = lineWidth;
	}

}
