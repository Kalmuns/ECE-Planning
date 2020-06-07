

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CreerSeance extends JPanel{
	
	
	   private JLabel jour;
	    private JLabel mois;
	    private JLabel annee;
    private JLabel semaineL;
    private JLabel heureDL;
    private JLabel dureeL;
    private JLabel coursNomL;
    private JLabel coursTypeL;


   // private JSpinner date;

    private JComboBox semaine;
    private JComboBox<Integer> heureD;
    private JComboBox<Integer> duree;
    private JComboBox coursNom;
    private JComboBox coursType;
    private JButton valider;
    private JPanel p;
    private JComboBox<Integer> j;
    private JComboBox<Integer> m;
    private JComboBox<Integer> a;
    private DAO dao;
    ArrayList<Cour> cours = new ArrayList<Cour>();
    ArrayList<TypeCour> type_cours= new ArrayList<TypeCour>();



    public CreerSeance() 
    {
      //  dateL = new JLabel("date: ");
        heureDL = new JLabel("heure de début: ");
        dureeL = new JLabel("durée du cours: ");
        coursNomL = new JLabel("nom du cours: ");
        coursTypeL = new JLabel("type de cours: ");
       // semaineL = new JLabel("numeros de la semaine");
        //semaine = new JComboBox();
        heureD = new JComboBox<Integer>();
        duree = new JComboBox<Integer>();
        coursNom = new JComboBox();
        coursType = new JComboBox();
        valider = new JButton("valider");
        valider.addActionListener(new ValiderListener());
        jour = new JLabel("  jour :");
        mois = new JLabel("  mois :");
        annee = new JLabel("  annee :");
        j=new JComboBox<Integer>();
        m=new JComboBox<Integer>();
        a= new JComboBox<Integer>();
      //  date = new JSpinner();
      
        dao = new DAO();
      



      //  date.setModel(new SpinnerDateModel());
     //   date.setEditor(new JSpinner.DateEditor(date, "yyyy-MM-dd"));

        p = new JPanel();
        for (int i = 1 ; i < 30 ; i++)
        {
            j.addItem(i);
        }
        for (int i = 1 ; i < 12; i++)
        {
            m.addItem(i);
        }
        for (int i = 2019 ; i < 2021 ; i++)
        {
            a.addItem(i);
        }
        
        for(int d = 1; d < 8 ; d++)
        {
            heureD.addItem(d);
        }

        for(int f = 1 ; f < 8 ; f++)
        {
            duree.addItem(f);
        }

        cours = dao.getallcour();
        type_cours = dao.getalltypecour();
        
        for(int i = 0 ; i < cours.size() ; i++)
        {
            coursNom.addItem(cours.get(i).getnom());
        }

        for(int i = 0 ; i < type_cours.size() ; i++)
        {
            coursType.addItem(type_cours.get(i).getsitenom());
        }

     //   date.getValue():
        p.setLayout(new GridLayout(7,2,1,10));

        //p.add(semaineL);
        //p.add(semaine);
       // p.add(dateL);
        //p.add(date);
        p.add(jour);
        p.add(j);
        p.add(mois);
        p.add(m);
        p.add(annee);
        p.add(a);
        p.add(heureDL);
        p.add(heureD);
        p.add(dureeL);
        p.add(duree);
        p.add(coursNomL);
        p.add(coursNom);
        p.add(coursTypeL);
        p.add(coursType);

        add(p);
        add(valider);
        this.setVisible(true);
    }
    
    private class ValiderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Outil outil=new Outil();
            InsertBDD insertBDD = new InsertBDD();
           // int resSemaine = (int) semaine.getSelectedItem();
      //      String resDate = new SimpleDateFormat("yyyy-MM-dd").format(date.getValue());
            Integer an= (Integer) a.getSelectedItem();
        	an=an.intValue()-1900;
        	Integer mo=(Integer) m.getSelectedItem();
        	Integer joInteger =(Integer) j.getSelectedItem();
            Integer resHeureD = (Integer) heureD.getSelectedItem();
            Integer resHeureF = (Integer) duree.getSelectedItem();
            java.sql.Date date= new java.sql.Date(an.intValue(),mo.intValue()-1,joInteger.intValue());
            int semaine= outil.convertirSemaine(date);
            String resCoursNom = String.valueOf(coursNom.getSelectedIndex());
            int resTypeCours = coursType.getSelectedIndex(); // recuperer l'ordre des types de cours
       //     System.out.println(resDate);
            insertBDD.insertSeance(date, resHeureD.intValue(), resHeureF.intValue(), 0, cours.get(coursNom.getSelectedIndex()).getID(), type_cours.get(coursType.getSelectedIndex()).getID());
            //ibdd.insertSeance(); // voir le InsertSeance (manque la semaine) convertir date en string
        }
    }
    
}