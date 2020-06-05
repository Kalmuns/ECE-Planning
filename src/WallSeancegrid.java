import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class WallSeancegrid extends JPanel{
	
	Wall wall;
	
	public WallSeancegrid(Wall walls)
	{
		wall=walls;
		this.setLayout(new BorderLayout());
		this.add(new SearchSeanceDisplay(this),BorderLayout.NORTH);
	}
	
	public void displaygrid(ArrayList<Seance> seances)
	{
		this.add(new GridSeanceDisplay(seances, wall),BorderLayout.CENTER);
	}
	
	
}
