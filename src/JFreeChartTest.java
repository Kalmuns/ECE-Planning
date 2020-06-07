import java.awt.Color;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



public class JFreeChartTest extends JPanel {
	
	public JFreeChartTest() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (Integer leint : new Integer[] {1,2,3,4,5,6,7,8,9,10}) {
			dataset.setValue(leint, "int", leint.toString());
        }
		
		JFreeChart chart = ChartFactory.createBarChart(
	    		"title",
	            "",
	            "yLabel",
	            dataset,
	            PlotOrientation.HORIZONTAL,
	            false, true, false);
	    ChartPanel chartPanel = new ChartPanel(chart);
	    chartPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    chartPanel.setBackground(Color.white);
	    add(chartPanel);
	}
	
}
