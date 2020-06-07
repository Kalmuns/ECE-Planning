import javax.swing.JFrame;
/**
 * Crée la fenetre pour afficher en dehors de la console
 * 
 *  
 *
 */
public class Fenetre extends JFrame
{
	private WallCalendrier wallCalendrier;
	private Wall wall;
	public Fenetre() {
	// TODO Auto-generated constructor stub
		this.setTitle("ECE PLANNING");		
		
//		this.add(new WallCalendrier());
		this.add(new Wall());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1600,800);
		this.setVisible(true);
//		wall= new Wall();
		// menu= new Menu(wall);
//		add(wall);
//		this.validate();
	}

}
