import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calendrier extends JPanel {
	
	// Display les information et contient le panel de cell
	
	
	public Calendrier() {
		//this.setLayout(new GridLayout(7,7));
		this.setLayout(new GridLayout(7,7,10,10));
		for(int i=0;i<7*7;i++)
		{
			this.add(new Cell());
		}
		this.setVisible(true);
		this.validate();
		
		
		// TODO Auto-generated constructor stub
	}
}
