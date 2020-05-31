import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel  {
    
	// navigation tu peux reprendre celui que j'avais fait dans l'ancien projet niveau structure

	private JButton accueil;
	private JButton etd;
	private JButton etudiants;
	protected Wall wall;
	public Menu(Wall wa)
	{
		accueil = new JButton ("Accueil");
		etd = new JButton ("ETD");
		etudiants = new JButton("Etudiantts");
		accueil.addActionListener(new AccueilListener());
		etd.addActionListener(new edtListener());
		etudiants.addActionListener(new etudiantListener());
		add(accueil);
		add (etd);
		add(etudiants);
		wall = wa;
		setVisible(false);
		setEnabled(false);
		this.validate();
	
		
		// TODO Auto-generated constructor stub
	}
	private class AccueilListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// wall.
		}

	}
	private class edtListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			wall.actual(new WallCalendrier());
		}

	}

	private class etudiantListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			wall.actual(new RechercheEtudiant(wall));
		}
	}

}
