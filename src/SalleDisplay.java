import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;



public class SalleDisplay extends JPanel {
	private ArrayList<Salle> todisplay=null;
	private ArrayList<NomBouton> boutton = new ArrayList<NomBouton>();
	private WallCalendrier wallCalendrier;
	private int j;
	int teString;
	int semaine;
	public SalleDisplay(ArrayList<Salle> salle, WallCalendrier c,int s)
	{
		int i=0;
		todisplay=salle;
		wallCalendrier =c;
		semaine=s;
		this.setLayout(new GridLayout(1,salle.size()));
		for(i=0;i<salle.size();i++)
		{
			int val=salle.get(i).getid();
			boutton.add(new NomBouton(new String("Salle: "+salle.get(i).getnom()),c,val));
			
			boutton.get(i).setBorderPainted(false);
			boutton.get(i).setBackground(Color.GRAY);
			
			this.add(boutton.get(i));
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
			
			
//			int prof_Nom = prof.getID();
			System.out.println("Nom: "+i);
			wallCalendrier.actualCalendrier(semaine, 5, i);
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
}