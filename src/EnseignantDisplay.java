import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class EnseignantDisplay extends JPanel {
	private ArrayList<Enseignant> todisplay=null;
	private ArrayList<JButton> boutton = new ArrayList<JButton>();
	private WallCalendrier wallCalendrier;
	private int j;
	public EnseignantDisplay(ArrayList<Enseignant> ens, WallCalendrier c)
	{
		int i=0;
		todisplay=ens;
		wallCalendrier =c;
		this.setLayout(new GridLayout(1,ens.size()));
		for(i=0;i<ens.size();i++)
		{
			boutton.add(new JButton(new String("Enseignant: "+ens.get(i).getnom())));
			
			boutton.get(i).setBorderPainted(false);
			boutton.get(i).setBackground(Color.GRAY);
			j=i;
			this.add(boutton.get(i));
			boutton.get(i).addActionListener(new NomBouton());
		}
		this.setVisible(true);
		this.validate();
	}
	private class NomBouton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Enseignant prof = todisplay.get(1);
			int prof_Nom = prof.getID();
			System.out.println(prof_Nom);
			wallCalendrier.actualCalendrier(1, 0, 0);
			
		}
	}
}
