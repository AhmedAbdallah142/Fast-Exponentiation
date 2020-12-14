package fastExponentiation;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class LineChart extends JFrame {
  private static dataController data;

  private static final long serialVersionUID = 1L;  
  
  public LineChart(String title) {
    super(title);  
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset(title);
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(  
        title, // Chart title
        "Number of bits", // X-Axis Label
        "time (Nano Second)", // Y-Axis Label
        dataset,
        PlotOrientation.VERTICAL,
            true,
            true,
            false
        );  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private DefaultCategoryDataset createDataset(String chartTitle) {
    String series1 = "Naive 1 Method",series2 = "Naive 2 Method",series3 = "Iterative Method",series4 = "Recursive Method";
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    switch (chartTitle){
      case "Line Chart":{
        for (int i=0;i<data.values.length;i++) {
          dataset.addValue(data.naive1[i], series1, (i + 1) * 3 + "");
          dataset.addValue(data.naive2[i], series2, (i + 1) * 3 + "");
          dataset.addValue(data.iterative[i], series3, (i + 1) * 3 + "");
          dataset.addValue(data.recursion[i], series4, (i + 1) * 3 + "");
        }
        break;
      }
      case "Naive1 Line Chart":{
        for (int i=0;i<data.values.length;i++){
          dataset.addValue(data.naive1[i], series1, (i+1)*3+"");
        }
        break;
      }
      case "Naive2 Line Chart":{
        for (int i=0;i<data.values.length;i++){
          dataset.addValue(data.naive2[i], series2, (i+1)*3+"");
        }
        break;
      }
      case "Iterative Line Chart":{
        for (int i=0;i<data.values.length;i++){
          dataset.addValue(data.iterative[i], series3, (i+1)*3+"");
        }
        break;
      }
      case "Recursive Line Chart":{
        for (int i=0;i<data.values.length;i++){
          dataset.addValue(data.recursion[i], series4, (i+1)*3+"");
        }
        break;
      }
    }
    return dataset;  
  }  
  
  public static void main(String[] args) {
    int[][] values = { { 5, 7, 4 }, { 40, 63, 32 }, { 350, 511, 256 }, { 3000, 4095, 2048 },
            { 19000, 32767, 16384 }, { 200000, 262143, 131072 }, { 1800000, 2097151, 1048576 },
            {10000000,16777215,8388608},/*{100000000,134217727,67108864}*/};
    data = new dataController(values);
    data.setData();
    SwingUtilities.invokeLater(() -> {
      LineChart example = new LineChart("Naive1 Line Chart");
      example.setAlwaysOnTop(true);
      example.pack();
      example.setSize(600, 400);
      example.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      example.setVisible(true);
    });
    SwingUtilities.invokeLater(() -> {
      LineChart example = new LineChart("Naive2 Line Chart");
      example.setAlwaysOnTop(true);
      example.pack();
      example.setSize(600, 400);
      example.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      example.setVisible(true);
    });
    SwingUtilities.invokeLater(() -> {
      LineChart example = new LineChart("Iterative Line Chart");
      example.setAlwaysOnTop(true);
      example.pack();
      example.setSize(600, 400);
      example.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      example.setVisible(true);
    });
    SwingUtilities.invokeLater(() -> {
      LineChart example = new LineChart("Recursive Line Chart");
      example.setAlwaysOnTop(true);
      example.pack();
      example.setSize(600, 400);
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