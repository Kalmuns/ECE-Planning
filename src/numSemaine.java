import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class numSemaine extends JPanel
{

    protected JButton selectSemaine;
    protected int idSemaine;
    protected WallCalendrier wallCalendrier;
    protected int salleLibre;
    protected int cont;
    public numSemaine(int idSemaine, int i, WallCalendrier c,int j,int contenu)
    {
    	selectSemaine selectSemaines =new selectSemaine(i+1 +"" , c );
    	wallCalendrier=c;
    	idSemaine = i+1;
    	salleLibre = j;
    	cont = contenu;
//        add(selectSemaine,BorderLayout.CENTER);
    	selectSemaines.setBackground(Color.white);
        add(selectSemaines);
        validate();

    }
    protected void actualliser (int i)
    {
    	
    	
    }
    private class selectSemaine extends JButton implements MouseListener
    {
    	private String name;
    	WallCalendrier calendrier;
    	int i;
        // A changer !!!!!!
    	public selectSemaine(String str, WallCalendrier c){
    	    super(str);
    	    this.name = str;
    	    this.calendrier =c;
    	    this.addMouseListener(this);
    	}

		@Override
		public void mouseClicked(MouseEvent e) {
			i = Integer.parseInt(name);
			if (salleLibre==0) {
				int id=wallCalendrier.getID();
				calendrier.actualCalendrier(i,id);
			}
			if (salleLibre ==1) {
				calendrier.actualCalendrier(i);
			}
			if (salleLibre ==2) {
				int id=wallCalendrier.getID();
				calendrier.actualCalendrier(i,2,cont,id);
			}
			if (salleLibre ==3) {
				int id=wallCalendrier.getID();
				calendrier.actualCalendrier(i,3,cont,id);
			}
			if (salleLibre ==4) {
				int id=wallCalendrier.getID();
				calendrier.actualCalendrier(i,4,cont,id);
			}
			if (salleLibre ==5) {
				int id=wallCalendrier.getID();
				calendrier.actualCalendrier(i,5,cont,id);
			}
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