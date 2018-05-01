package pl.java.lab9.zadanie1;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Sinus {

	List<Double> yAxis = generateSinus(0.1);

	public Sinus() {
		// yAxis.forEach(System.out::println);
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(createDataset());
		JFreeChart chart = ChartFactory.createXYLineChart("Sinus", "x", "y", dataset);
		ChartFrame frame = new ChartFrame("Plot sinus", chart);
		frame.setPreferredSize(new Dimension(600, 400));
		frame.pack();
		frame.setVisible(true);
	}

	private XYSeries createDataset() {
		XYSeries series = new XYSeries("Sinus");
		for (int i = 0; i < yAxis.size(); i++) {
			series.add(i, yAxis.get(i));
		}
		return series;
	}

	private List<Double> generateSinus(double density) {
		List<Double> tmp = new ArrayList<>();
		for (double i = 0; i < 10; i+=density) {
			tmp.add(Math.sin(i));
		}
		return tmp;
	}

	public static void main(String[] args) {
		new Thread(() -> {
			new Sinus();
		}).start();
	}

}
