package pl.java.lab9.zadanie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.Value;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PlotFromFile {

	public PlotFromFile(String title) {
		XYDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createScatterPlot(title, "x", "y", dataset);

		ChartFrame frame = new ChartFrame("random", chart);
		frame.pack();
		frame.setVisible(true);
	}

	private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("Random points");
		String filename = "plot.txt";
		List<Double> x = new ArrayList<>();
		List<Double> y = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				String[] str = s.split(" ");
				x.add(Double.valueOf(str[0]));
				y.add(Double.valueOf(str[1]));
			}
			for (int i = 0; i < x.size(); i++) {
				series.add(x.get(i), y.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataset.addSeries(series);
		return dataset;
	}

	public static void main(String[] args) {
		new Thread(() -> {
			new PlotFromFile("Random");
		}).start();
	}

}
