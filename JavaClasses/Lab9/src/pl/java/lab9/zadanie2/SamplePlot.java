package pl.java.lab9.zadanie2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;

import com.orsonpdf.DefaultFontMapper;
import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.PDFObject;
import com.orsonpdf.Page;
import com.orsonpdf.util.GraphicsUtils;
import com.orsonpdf.util.TextAnchor;
import com.orsonpdf.util.TextUtils;

public class SamplePlot {

	List<String> country = new ArrayList<>();
	List<String> numbers = new ArrayList<>();
	List<Double> nums;
	private Graphics2D g2d;

	public SamplePlot() {

		JFreeChart chart = createChart(createDataset());
		PDFDocument pdfDoc = new PDFDocument();
		pdfDoc.setTitle("BarChart3D");
		pdfDoc.setAuthor("Robert Jankowski");
		Page page = pdfDoc.createPage(new Rectangle(612, 468));
		PDFGraphics2D g2 = page.getGraphics2D();
		chart.draw(g2, new Rectangle(0, 0, 612, 468));
		Page page2 = pdfDoc.createPage(new Rectangle(0, 0, 612, 468));
		PDFGraphics2D g22 = page2.getGraphics2D();
		drawString(g22);
		Page page3 = pdfDoc.createPage(new Rectangle(0, 0, 612, 468));
		g22 = page3.getGraphics2D();
		drawShapes(g22);
		drawImage(g22, "tapeta.jpg");
		pdfDoc.writeToFile(new File("barchar.pdf"));
	}

	private void drawString(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		for (int i = 0; i < nums.size(); i++) {
			String tmp = nums.get(i) + "  :  " + country.get(i);
			g2d.drawString(tmp, 100, i * 30 + 100);
		}
	}

	private void drawShapes(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(new int[] { 222, 211, 331, 431 }, new int[] { 313, 341, 452, 136, 334 }, 4);
		g2d.drawOval(450, 400, 50, 50);
		g2d.fillRect(300, 300, 20, 30);
	}

	private void drawImage(Graphics2D g2d, String filename) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2d.drawImage(img, 100, 100, 200, 200,null);
	}

	private CategoryDataset createDataset() {
		loadData();
		DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();
		for (int i = 0; i < nums.size(); i++) {
			dataset.add((double) nums.get(i), i, country.get(i), country.get(i));
		}
		return dataset;
	}

	private JFreeChart createChart(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart3D("Title", "country", "money", dataset);

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(false);
		StatisticalBarRenderer renderer = new StatisticalBarRenderer();
		renderer.setDrawBarOutline(false);
		renderer.setErrorIndicatorPaint(Color.black);
		renderer.setIncludeBaseInRange(false);
		plot.setRenderer(renderer);
		ChartUtilities.applyCurrentTheme(chart);

		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseItemLabelPaint(Color.yellow);
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition());
		return chart;

	}

	private void loadData() {
		String csvFile = "data.csv";
		String csvSplitBy = ",";
		try (Scanner s = new Scanner(new File(csvFile))) {
			while (s.hasNextLine()) {
				String r = s.nextLine();
				String[] tmp = r.split(csvSplitBy);
				country.add(tmp[0]);
				numbers.add(tmp[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		nums = numbers.stream().map(e -> e.substring(1, e.length() - 1)).map(Double::valueOf)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		new Thread(() -> {
			new SamplePlot();
		}).start();
	}

}
