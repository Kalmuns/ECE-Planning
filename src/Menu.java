import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel  {

    // navigation tu peux reprendre celui que j'avais fait dans l'ancien projet niveau structure

    private JButton accueil;
    private JButton edt;
    private JButton user;
    private JButton affectation;
    private JButton seance;
    protected Wall wall;
    public Menu(Wall wa)
    {
        accueil = new JButton ("Accueil");
        edt = new JButton ("EDT");
        user = new JButton("Utilisateurs");
        affectation = new JButton("Affectation"); // faire un dropdown pour les diff'rentes affectations
        seance = new JButton("Seance");
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

    private class userListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            wall.actual(new RechercheUser(wall));
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
            wall.actual(new AffecterSeanceDisplay());

        }
    }

}