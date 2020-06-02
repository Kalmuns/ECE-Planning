import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Cell extends JPanel{

	
	public Cell() {
		this.setLayout(new BorderLayout());
		add(new JButton("promo"),BorderLayout.NORTH);
		add(new JButton("enseignant"),BorderLayout.CENTER);
		add(new JButton("matiere"),BorderLayout.SOUTH);
		this.validate();
		// TODO Auto-generated constructor stub
		// Case du tableaux n'est qu'un display les info passe par le constructeur. 
	}
}
