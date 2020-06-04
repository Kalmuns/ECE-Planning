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

    public numSemaine(int idSemaine, int i, WallCalendrier c)
    {
    	selectSemaine selectSemaines =new selectSemaine(i+1 +"" , c );
    	idSemaine = i+1;
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
			
			calendrier.actualCalendrier(i);
			if(e.getSource().getClass()== selectSemaine.class)
			{
				
				selectSemaine boutonsButton = (selectSemaine) e.getSource();
				
				//System.out.println( "Bla" +boutonsButton.getName());
				
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