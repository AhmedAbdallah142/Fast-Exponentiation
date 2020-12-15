package fastExponentiation;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class LineChart extends JFrame {
	private static DataController data;

	private static final long serialVersionUID = 1L;

	public LineChart(String title) {
		super(title);
		// Create dataset
		DefaultCategoryDataset dataset = createDataset(title);
		// Create chart
		JFreeChart chart = ChartFactory.createLineChart(title, // Chart title
				"Number of bits", // X-Axis Label
				"time (Nano Second)", // Y-Axis Label
				dataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}

	private DefaultCategoryDataset createDataset(String chartTitle) {
		String series1 = "Naive 1 Method", series2 = "Naive 2 Method", series3 = "Iterative Method",
				series4 = "Recursive Method";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		switch (chartTitle) {
		case "Line Chart": {
			for (int i = 1; i < data.values.length; i++) {
				if (data.naive1[i][0] != -1.0) {
					dataset.addValue(data.naive1[i][1], series1, (i) + "");
				} else {
					dataset.addValue(0, series1, (i) + "");
				}
				if (data.naive2[i][0] != -1.0) {
					dataset.addValue(data.naive2[i][1], series2, (i) + "");
				} else {
					dataset.addValue(0, series2, (i) + "");
				}
				if (data.iterative[i][0] != -1.0) {
					dataset.addValue(data.iterative[i][1], series3, (i) + "");
				} else {
					dataset.addValue(0, series3, (i) + "");
				}
				if (data.recursion[i][0] != -1.0) {
					dataset.addValue(data.recursion[i][1], series4, (i) + "");
				} else {
					dataset.addValue(0, series4, (i) + "");
				}
			}
			break;
		}
		case "Naive1 Line Chart": {
			for (int i = 1; i < data.values.length; i++) {
				if (data.naive1[i][0] != -1.0) {
					dataset.addValue(data.naive1[i][1], series1, (i) + "");
				} else {
					dataset.addValue(0, series1, (i) + "");
				}
			}
			break;
		}
		case "Naive2 Line Chart": {
			for (int i = 1; i < data.values.length; i++) {
				if (data.naive2[i][0] != -1.0) {
					dataset.addValue(data.naive2[i][1], series2, (i) + "");
				} else {
					dataset.addValue(0, series2, (i) + "");
				}
			}
			break;
		}
		case "Iterative Line Chart": {
			for (int i = 1; i < data.values.length; i++) {
				if (data.iterative[i][0] != -1.0) {
					dataset.addValue(data.iterative[i][1], series3, (i) + "");
				} else {
					dataset.addValue(0, series3, (i) + "");
				}
			}
			break;
		}
		case "Recursive Line Chart": {
			for (int i = 1; i < data.values.length; i++) {
				if (data.recursion[i][0] != -1.0) {
					dataset.addValue(data.recursion[i][1], series4, (i) + "");
				} else {
					dataset.addValue(0, series4, (i) + "");
				}
			}
			break;
		}
		}
		return dataset;
	}

	public static void main(String[] args) {
		long[][] values = { { 1, 1, 1 }, { 1, 1, 1 }, { 2, 3, 4 }, { 4, 5, 7 }, { 8, 10, 15 }, { 16, 25, 31 },
				{ 32, 40, 63 }, { 64, 100, 127 }, { 128, 200, 255 }, { 256, 350, 511 }, { 512, 900, 1023 },
				{ 1024, 1500, 2047 }, { 2048, 3000, 4095 }, { 4096, 6000, 8191 }, { 8192, 10000, 16383 },
				{ 16384, 19000, 32767 }, { 32768, 40000, 65535 }, { 65536, 100000, 131071 }, { 131072, 200000, 262143 },
				{ 262144, 300000, 524287 }, { 524288, 850000, 1048575 }, { 1048576, 1800000, 2097151 },
				{ 2097152, 3000000, 4194303 }, { 4194304, 6000000, 8388607 }, { 8388608, 10000000, 16777215 },
				{ 16777216, 20000000, 33554431 }, { 33554432, 50000000, 67108863 }, { 67108864, 100000000, 134217727 },
				{ 134217728, 190000000, 268435455 }, { 268435456, 350000000, 536870912 } };
		data = new DataController(values);
		data.setData();
		for (int i = 1; i < data.values.length; i++) {
			System.out.println("Results for " + i + " bits, When Over flow Occurred the result equal -1 \nnaive 1 => "
					+ data.naive1[i][0] + "\t naive 2 => " + data.naive2[i][0] + "\t Iterative => " + data.iterative[i][0]
					+ "\t Recursive => " + data.recursion[i][0]
					+ "\n------------------------------------------------------------------------------------------");
		}
		
		SwingUtilities.invokeLater(() -> {
			LineChart example = new LineChart("Naive1 Line Chart");
			example.setAlwaysOnTop(true);
			example.pack();
			example.setSize(700, 400);
			example.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			example.setVisible(true);
		});
		SwingUtilities.invokeLater(() -> {
			LineChart example = new LineChart("Naive2 Line Chart");
			example.setAlwaysOnTop(true);
			example.pack();
			example.setSize(700, 400);
			example.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			example.setVisible(true);
		});
		SwingUtilities.invokeLater(() -> {
			LineChart example = new LineChart("Iterative Line Chart");
			example.setAlwaysOnTop(true);
			example.pack();
			example.setSize(700, 400);
			example.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			example.setVisible(true);
		});
		SwingUtilities.invokeLater(() -> {
			LineChart example = new LineChart("Recursive Line Chart");
			example.setAlwaysOnTop(true);
			example.pack();
			example.setSize(700, 400);
			example.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			example.setVisible(true);
		});
		SwingUtilities.invokeLater(() -> {
			LineChart example = new LineChart("Line Chart");
			example.setAlwaysOnTop(true);
			example.pack();
			example.setSize(1000, 800);
			example.setLocationRelativeTo(null);
			example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			example.setVisible(true);
		});
	}
}