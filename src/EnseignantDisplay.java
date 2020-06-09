import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Affiche des boutons dans un JPanel seance 
 * Se construit en largeur
 * 
 *  
 *
 */

public class EnseignantDisplay extends JPanel {
	private ArrayList<Enseignant> todisplay=null;
	private ArrayList<NomBouton> boutton = new ArrayList<NomBouton>();
	private WallCalendrier wallCalendrier;
	private int j;
	int teString;
	int semaine;
	public EnseignantDisplay(ArrayList<Enseignant> ens, WallCalendrier c,int s)
	{
		int i=0;
		todisplay=ens;
		wallCalendrier =c;
		semaine=s;
		this.setLayout(new GridLayout(1,ens.size()));
		for(i=0;i<ens.size();i++)
		{
			int val=ens.get(i).getID();
			boutton.add(new NomBouton(new String("Enseignant: "+ens.get(i).getnom()),c,val));
			
			teString=ens.get(i).getID();
			boutton.get(i).setBorderPainted(false);
			boutton.get(i).setBackground(Color.GRAY);
			String tString = new String();
			tString =Integer.toString(i);
			
			boutton.get(i).setName(tString);
			this.add(boutton.get(i));
			//System.out.println(boutton.get(i).getName());
			
		}
		this.setVisible(true);
		this.validate();
	}
	private class NomBouton extends JButton implements MouseListener
    {
    	private String name;
    	WallCalendrier calendrier;
    	int i;
        // A changer !!!!!!
    	public NomBouton(String str, WallCalendrier c,int val){
    	    super(str);
    	    i=val;
    	    this.name = str;
    	    this.calendrier =c;
    	    this.addMouseListener(this);
    	}

		@Override
		public void mouseClicked(MouseEvent e) {
			
//			Enseignant prof = todisplay.get(1);
//			int prof_Nom = prof.getID();
			//System.out.println("Nom: "+i);
			wallCalendrier.actualCalendrier(semaine, 3, i,wallCalendrier.getID());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
    }
	/////
	
}
