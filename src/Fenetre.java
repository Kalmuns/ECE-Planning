import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	public Fenetre() {
	// TODO Auto-generated constructor stub
		this.setTitle("ECE PLANNING");		
		
		this.add(new WallCalendrier());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1600,800);
		this.setVisible(true);
	}

}
