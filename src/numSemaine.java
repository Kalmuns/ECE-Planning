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

    public numSemaine(int idSemaine, int i)
    {
    	selectSemaine selectSemaines =new selectSemaine(i+1 +""  );
//        add(selectSemaine,BorderLayout.CENTER);
    	selectSemaines.setBackground(Color.white);
        add(selectSemaines);
        validate();

    }
    private class selectSemaine extends JButton implements MouseListener
    {
    	private String name;
    	int i;
        // A changer !!!!!!
    	public selectSemaine(String str){
    	    super(str);
    	    this.name = str;
    	    this.addMouseListener(this);
    	}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			i = Integer.parseInt(name);
			Calendrier c = new Calendrier(i);
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