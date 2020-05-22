import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SemaineDisplay extends JPanel{
	public SemaineDisplay() {
	
		this.setLayout(new GridLayout(1,7));
		for(int i=0;i<7;i++)
		{
			this.add(new JLabel("test"));
		}
		
		// TODO Auto-generated constructor stub
	}
}
