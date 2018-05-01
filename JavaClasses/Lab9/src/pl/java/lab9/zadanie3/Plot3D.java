package pl.java.lab9.zadanie3;

import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.UIUtilities;

public class Plot3D extends ApplicationFrame {

	// naprawde to nie wykres3d to przyklad z jfreechart!
	public Plot3D(String title) {
		super(title);
		JFreeChart chart = createChart(createDataset());
		ChartPanel chartPanel = new ChartPanel(chart, false);
		chartPanel.setFillZoomRectangle(true);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setPreferredSize(new Dimension(500, 500));
		this.setContentPane(chartPanel);
	}

	private static CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(10, "x", "y");
		dataset.addValue(30, "x", "y");
		dataset.addValue(20, "x", "y1");
		return dataset;
	}

	private static JFreeChart createChart(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart("Sample bar", "x", "y", dataset);

		chart.addSubtitle(new TextTitle("Hello subtitle"));
		chart.setBackgroundPaint(Color.YELLOW);

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		chart.getLegend().setFrame(BlockBorder.NONE);
		return chart;
	}

	public static void main(String[] args) {
		Plot3D plot3d = new Plot3D("fff");
		plot3d.pack();
		plot3d.setVisible(true);
	}
	
}
