import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;



public class Cell extends JPanel{

	private Utilisateur user;
	Seance seanceSeance;
	public Cell( Seance cell_seance,Utilisateur users) {
		this.setLayout(new GridLayout(0,1));
		user=users;
		seanceSeance = cell_seance;
		//On r�cup�re le nom du cours
		Cour cours = cell_seance.getCour();
		String cours_Nom = cours.getnom();
		
		//On r�cup�re le Type de cours
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
		
		
		
		//On r�cup�re le num�ro de salle et du batiment
		ArrayList<Salle> salles = cell_seance.getsalle();
		add(new SalleDisplay(salles));
		
		
		//add(Salle,BorderLayout.SOUTH);
		if (users.getdroit() == 0) {
			JButton supprButton = new JButton("Supprimer");
			supprButton.setBorderPainted(false);
			supprButton.setBackground(Color.RED);
			add(supprButton,BorderLayout.NORTH);
			supprButton.addActionListener(new DeleteBoutton());
		}
		
		this.update(this.getGraphics());
		this.validate();
		paint(this.getGraphics());
		this.grabFocus();
		
		// TODO Auto-generated constructor stub
		// Case du tableaux n'est qu'un display les info passe par le constructeur. 
	}
	private class DeleteBoutton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DeleterBDD supprimer = new DeleterBDD();
			supprimer.suppSeance(seanceSeance.getidseance());
		}
	}
}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
