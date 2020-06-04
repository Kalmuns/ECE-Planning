import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calendrier extends JPanel {
	
	// Display les information et contient le panel de cell
	
	
	public Calendrier(int semaine) {
		//this.setLayout(new GridLayout(7,7));
		DAO dao = new DAO();
		Seance seances=dao.getSeancebyID(1);
		System.out.println("Semaine: " +semaine );
		this.setLayout(new GridLayout(7,7,10,10));
		for(int i=0;i<7*7;i++)
		{
			 
			this.add(new Cell(seances));
		}
		this.setVisible(true);
		this.validate();
		
		
		// TODO Auto-generated constructor stub
	}
}
