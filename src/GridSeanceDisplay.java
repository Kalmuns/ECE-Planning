import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GridSeanceDisplay extends JPanel{

		public GridSeanceDisplay(ArrayList<Seance> seances,Wall wall)
		{
			if (seances!=null)
			{
				this.setLayout(new GridLayout(seances.size(), 1));
				int i;
				for(i=0;i<seances.size();i++)
				{
					this.add(new RowSeanceGridDisplay(seances.get(i), wall));
				}
				
			}
			this.setVisible(true);
			this.validate();
			this.getParent().getParent().revalidate();
			this.getParent().getParent().paint(this.getParent().getParent().getGraphics());
		}
	
}
