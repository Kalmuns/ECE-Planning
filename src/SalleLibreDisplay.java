
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SalleLibreDisplay extends JPanel {
	private ArrayList<Salle> todisplay=null;
	private ArrayList<JLabel> panneau = new ArrayList<JLabel>();
	public SalleLibreDisplay(ArrayList<Salle> gr)
	{
		int i=0;
		todisplay=gr;
		this.setLayout(new GridLayout(1,gr.size()));
		for(i=0;i<gr.size();i++)
		{
			panneau.add(new JLabel(new String(""+gr.get(i).getnom())));
			panneau.get(i).setBackground(Color.GRAY);
			
			this.add(panneau.get(i));
		}
		this.setVisible(true);
		this.validate();
	}
}