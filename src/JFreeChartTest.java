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
		Outil toolOutil = new Outil();
		DAO dao= new DAO();
		int test =dao.getCapaciteSalle(3);
		for (Integer leint : new Integer[] {dao.getCapaciteSalle(1),dao.getCapaciteSalle(2),test}) {
			dataset.setValue(leint, "int", leint.toString());
        }
		
		JFreeChart chart = ChartFactory.createBarChart(
	    		"Titre",
	            "",
	            "Total des Capacité des salles",
	            dataset,
	            PlotOrientation.HORIZONTAL,
	            false, true, false);
	    ChartPanel chartPanel = new ChartPanel(chart);
	    chartPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    chartPanel.setBackground(Color.white);
	    add(chartPanel);
	}
	
}
