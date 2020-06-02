import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Cell extends JPanel{

	
	public Cell() {
		this.setLayout(new GridLayout(0,1));
		JButton Nom = new JButton("Nom et Type de Cours");
		Nom.setBorderPainted(false);
		Nom.setBackground(Color.GRAY);
		add(Nom,BorderLayout.NORTH);
		
		JButton Prof = new JButton("Enseignant");
		Prof.setBorderPainted(false);
		Prof.setBackground(Color.GRAY);
		add(Prof,BorderLayout.CENTER);
		
		JButton Td = new JButton("TD et Groupe");
		Td.setBorderPainted(false);
		Td.setBackground(Color.GRAY);
		add(Td,BorderLayout.SOUTH);
		
		
		JButton Salle = new JButton("Salle et Batiment");
		Salle.setBorderPainted(false);
		Salle.setBackground(Color.GRAY);
		add(Salle,BorderLayout.SOUTH);
		
		
		
		this.validate();
		// TODO Auto-generated constructor stub
		// Case du tableaux n'est qu'un display les info passe par le constructeur. 
	}
}
