import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel  {
    
	// navigation tu peux reprendre celui que j'avais fait dans l'ancien projet niveau structure

	private JButton accueil;
	private JButton etd;
	private JButton user;
	private JButton salleLibre;
	protected Wall wall;
	public Menu(Wall wa)
	{
		accueil = new JButton ("Accueil");
		etd = new JButton ("ETD");
		user = new JButton("Utilisateurs");
		salleLibre = new JButton("Salle Libre");
		accueil.addActionListener(new AccueilListener());
		etd.addActionListener(new edtListener());
		user.addActionListener(new userListener());
		salleLibre.addActionListener(new salleLibreListener());
		//add(accueil);
		add (etd);
		add(user);
		add(salleLibre);
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
			//wall.actual(new WallCalendrier());
			wall.actual(new WallCalendrier());
			
		}

	}

	private class userListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			wall.actual(new RechercheUser(wall));
		}
	}
	private class salleLibreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			wall.actual(new WallCalendrier(0,0));
		}
	}

}
