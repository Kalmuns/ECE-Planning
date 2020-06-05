import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SalleDisplay extends JPanel {
	private ArrayList<Salle> todisplay=null;
	private ArrayList<JButton> boutton = new ArrayList<JButton>();
	public SalleDisplay(ArrayList<Salle> salle)
	{
		int i=0;
		todisplay=salle;
		this.setLayout(new GridLayout(1,salle.size()));
		for(i=0;i<salle.size();i++)
		{
			boutton.add(new JButton(new String("Salle: "+salle.get(i).getnom())));
			
			boutton.get(i).setBorderPainted(false);
			boutton.get(i).setBackground(Color.GRAY);
			
			this.add(boutton.get(i));
		}
		this.setVisible(true);
		this.validate();
	}
}