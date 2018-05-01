package pl.java.lab9.zadanie3;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Bonus3D extends JFrame {

	public Bonus3D(String title) {
		super(title);

	}

	public static JPanel createPanel() {

	}
	// nie widzi biblioteki !
	public static XYZDataset<String> createDataset() {
		XYZSeriesCollection<String> dataset = new XYZSeriesCollection<String>();

		for (int s = 1; s < 24; s++) {
			XYZSeries<String> series = new XYZSeries<String>("Series " + s);
			double y = 1.0;
			for (int i = 0; i < 3000; i++) {
				y = y * (1.0 + (Math.random() - 0.499) / 10.0);
				series.add(i, y, s);
			}
			dataset.add(series);
		}

		return dataset;
	}

}
