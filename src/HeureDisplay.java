import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeureDisplay extends JPanel{

	public HeureDisplay() {
		// TODO Auto-generated constructor stub
	
	this.setLayout(new GridLayout(7,1));
	for(int i=0;i<7;i++)
	{
		this.add(new JLabel("test"));
	}
	}
}
