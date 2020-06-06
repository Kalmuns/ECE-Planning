import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel  {


    private JButton accueil;
    private JButton edt;
    private JButton user;
    private JButton affectation;
    private JButton seance;
    private JButton salleLibre;
    protected Wall wall;
    
    public Menu(Wall wa)
    {
        accueil = new JButton ("Accueil");
        edt = new JButton ("EDT");
        user = new JButton("Utilisateurs");
        affectation = new JButton("Affectation"); // faire un dropdown pour les diff'rentes affectations
        seance = new JButton("Seance");
        salleLibre = new JButton("Salle Libre");
        salleLibre.addActionListener(new salleLibreListener());
        accueil.addActionListener(new AccueilListener());
        edt.addActionListener(new edtListener());
        user.addActionListener(new userListener());
        affectation.addActionListener(new AffectationListener());
        seance.addActionListener(new SeanceListener());
        
        //add(accueil);
        add (edt);
        add(user);
        add(affectation);
        add(seance);
        add(salleLibre);
        wall = wa;
        setVisible(false);
        setEnabled(false);
        this.validate();



    }
	private class salleLibreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			wall.actual(new WallCalendrier(0,0));
		}
	}

        // TODO Auto-generated constructor stub
    
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

    private class userListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            wall.actual(new WallUtilisateur(wall));
        }
    }
    private class AffectationListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            wall.actual(new AffecterProfDisplay());
        }
    }

    private class SeanceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            wall.actual(new WallSeancegrid(wall));

        }
    }

}