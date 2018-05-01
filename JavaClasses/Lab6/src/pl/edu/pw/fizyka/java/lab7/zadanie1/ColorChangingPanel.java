package pl.edu.pw.fizyka.java.lab7.zadanie1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ColorChangingPanel extends JPanel {

	Color currentColor;
	Color[] targetColor = { Color.WHITE, Color.BLUE, Color.YELLOW, Color.RED, Color.BLACK, Color.GREEN };
	int changingSpeed = 5;

	public ColorChangingPanel() {
		this.setBackground(Color.BLUE);
		this.setPreferredSize(new Dimension(200, 200));
		new Thread(() -> {
			while (true) {
				Toolkit.getDefaultToolkit().sync();
				for (int j = 0; j < targetColor.length; j++) {
					final Integer innerJ = new Integer(j);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					currentColor = getBackground();
					int r = currentColor.getRed();
					int g = currentColor.getGreen();
					int b = currentColor.getBlue();

					double dr = targetColor[innerJ].getRed() - r;
					double dg = targetColor[innerJ].getGreen() - g;
					double db = targetColor[innerJ].getBlue() - b;

					double norm = Math.sqrt(dr * dr + dg * dg + db * db);
					dr /= norm;
					dg /= norm;
					db /= norm;
					dr *= Math.min(changingSpeed, norm);
					dg *= Math.min(changingSpeed, norm);
					db *= Math.min(changingSpeed, norm);
					r += dr;
					g += dg;
					b += db;
					setBackground(new Color(r, g, b));
					repaint();

				}
			}

		}).start();

	}
}
