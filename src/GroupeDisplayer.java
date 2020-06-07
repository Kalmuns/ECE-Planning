

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


public class GroupeDisplayer extends JPanel {
	private ArrayList<Groupe> todisplay=null;
	private ArrayList<NomBouton> boutton = new ArrayList<NomBouton>();
	private WallCalendrier wallCalendrier;
	int j;
	int teString;
	int semaine;
	
	public GroupeDisplayer(ArrayList<Groupe> gr, WallCalendrier c,int s)
	{
		int i=0;
		j=i;
		wallCalendrier=c;
		todisplay=gr;
		semaine=s;
		this.setLayout(new GridLayout(1,gr.size()));
		for(i=0;i<gr.size();i++)
		{
			int val=gr.get(i).getid();
			boutton.add(new NomBouton(new String("gr"+gr.get(i).getnom()),c,val));
			
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
			//System.out.println("Nom: "+i);
			wallCalendrier.actualCalendrier(semaine, 4, i,wallCalendrier.getID());
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
