package pl.randomwalk;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Chart {

	XYSeries walk = new XYSeries("Random walk");
	XYSeriesCollection dataset = new XYSeriesCollection();
	JFreeChart chart;

	// dodanie punktow
	public void addToChart(int x, int y) {
		walk.add(x, y);
	}

	public void addToDataset() {
		chart = ChartFactory.createXYLineChart("Random walk", "UP", "DOWN", dataset);
		dataset.addSeries(walk);
	}

	// zapis
	public void saveChart() {
		try {
			ChartUtilities.saveChartAsJPEG(new File("randomwalk.jpg"), chart, 500, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
