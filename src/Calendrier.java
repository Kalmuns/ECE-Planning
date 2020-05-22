import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calendrier extends JPanel {
	
	// Display les information et contient le panel de cell
	
	
	public Calendrier() {
		this.setLayout(new GridLayout(7,7));
	
		for(int i=0;i<45;i++)
		{
			this.add(new JLabel("test"));
		
		
		// TODO Auto-generated constructor stub
	}
}
}
