import java.awt.BorderLayout;

import javax.swing.JPanel;

public class WallCalendrier extends JPanel{

	
	public WallCalendrier() {
	
		this.setLayout(new BorderLayout());
		add(new SemaineDisplay(),BorderLayout.NORTH);
		add(new HeureDisplay(),BorderLayout.WEST);
		add(new Calendrier(),BorderLayout.CENTER);
		 
		
		
		// TODO Auto-generated constructor stub
	}
}
