import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Cell extends JPanel{

	
	public Cell( Seance cell_seance) {
		this.setLayout(new GridLayout(0,1));
		
		
		//On récupère le nom du cours
		Cour cours = cell_seance.getCour();
		String cours_Nom = cours.getnom();
		
		//On récupère le Type de cours
		TypeCour type = cell_seance.gettypeCour();
		String type_Nom = type.getsitenom();
		
		
		JButton Nom = new JButton(cours_Nom + type_Nom);
		Nom.setBorderPainted(false);
		Nom.setBackground(Color.GRAY);
		add(Nom,BorderLayout.NORTH);
		
		
		ArrayList<Enseignant> enseignant = cell_seance.getEnseignants();
		add(new EnseignantDisplay(enseignant));
		
		
		//JButton Prof = new JButton("Enseignant");
		//Prof.setBorderPainted(false);
		//Prof.setBackground(Color.GRAY);
		//add(Prof,BorderLayout.CENTER);
		
		
		ArrayList<Groupe> groupe = cell_seance.getgroupes();
		add(new GroupeDisplayer(groupe));
		
		
		
		//On récupère le numéro de salle et du batiment
		ArrayList<Salle> salles = cell_seance.getsalle();
		add(new SalleDisplay(salles));
		
		
		//add(Salle,BorderLayout.SOUTH);
		
		
		
		this.validate();
		// TODO Auto-generated constructor stub
		// Case du tableaux n'est qu'un display les info passe par le constructeur. 
	}
}
