
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * affiche les salle libres 
 * @author Kalmuns
 *
 */
public class SalleLibreDisplay extends JPanel {
	private ArrayList<Salle> todisplay=null;
	private ArrayList<JLabel> panneau = new ArrayList<JLabel>();
	public SalleLibreDisplay(ArrayList<Salle> salles)
	{
		
		int i=0;
		todisplay=salles;
		this.setLayout(new GridLayout(3,(salles.size())/3));
		for(i=0;i<salles.size();i++)
		{
			panneau.add(new JLabel(new String(""+salles.get(i).getnom())));
			panneau.get(i).setBackground(Color.GRAY);
			
			this.add(panneau.get(i));
		}
		this.setVisible(true);
		this.validate();
	}
}