import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
/**
 * panneaux jouter dans mur regroupant recherche utilisateur et par la suite gridutilisateur
 * 
 * @author Kalmuns
 *
 */


public class WallUtilisateur extends JPanel {

	Wall wall;
	
	 public WallUtilisateur(Wall walls) {
		// TODO Auto-generated constructor stub
	
		wall=walls;
		this.setLayout(new BorderLayout());
		this.add(new RechercheUser(this),BorderLayout.NORTH);
	}
//	
	public void displaygrid(ArrayList<Enseignant> enseignants)
	{
////		System.out.println(" nb composant wallseancegri"+ this.getComponentCount());
   	    this.add(new GridUtilisateurSeanceDisplay(enseignants),BorderLayout.CENTER);
		//System.out.println(" nb composant wallseancegri"+ this.getComponentCount());
		this.revalidate();
	}
}
