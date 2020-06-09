import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
/**
 * Interface possedant tout les listener necessaire a la modification d'une seance
 * Ils appellent au besoin INsertBDD ou DeleteBDD
 * 
 *  
 *
 */

public class ModifSeanceDisplay extends JPanel
{
    //
    private JLabel dateL;
    private JLabel heureDL;
    private JLabel dureeL;
    private JLabel coursNomL;
    private JLabel coursTypeL;
    private ArrayList <JLabel> salleL;
    private ArrayList <JLabel> enseignantL;
    private ArrayList <JLabel> groupeL;
//
    private JSpinner date;
    private JComboBox<Integer> heureD;
    private JComboBox<Integer> duree;
    private JComboBox<String> coursNom;
    private JComboBox<String> coursType;
    private JComboBox<String> salleCB;
    private JComboBox<String> enseignantCB;
    private JComboBox<String> groupeCB;


    private JButton valider;
    private JButton supSalle;
    private JButton supEnseignant;
    private JButton supGroupe;
    private JButton addSalle;
    private JButton addEnseignant;
    private JButton addGroupe;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    ArrayList<Cour> cours = new ArrayList<Cour>();
    ArrayList<TypeCour> type_cours= new ArrayList<TypeCour>();
    ArrayList<Salle> salles=new ArrayList<Salle>();
    ArrayList<Enseignant> enseignants=new ArrayList<Enseignant>();
    ArrayList<Groupe> groupe= new ArrayList<Groupe>();
//
//    private ArrayList<Seance> seance;
    private Outil outil;
    private DAO dao;
    private Seance seance;
    private Wall wall;
    
    public ModifSeanceDisplay(String seanceID, Wall walls)   {
        dao = new DAO();
        seance=dao.getSeancebyID(Integer.parseInt(seanceID));
        //System.out.println( " teststart "+ seance.getEnseignants().get(1).getnom());
        wall=walls;


        salleL = new ArrayList<>();
        enseignantL = new ArrayList<>();
        groupeL = new ArrayList<>();

        cours = dao.getallcour();
        type_cours = dao.getalltypecour();
        salles = dao.getallsalle();
        enseignants = dao.getallenEnseignants();
        groupe = dao.getallgroupe();
        salleCB = new JComboBox<String>();
        enseignantCB = new JComboBox<String>();
        groupeCB = new JComboBox<String>();
        
        
        dateL = new JLabel("date: ");
        heureDL = new JLabel("heur de début: ");
        dureeL = new JLabel("durée: ");
        coursNomL = new JLabel("nom du cours");
        coursTypeL = new JLabel("type de cours");


        for(int i = 0 ; i < salles.size() ; i++)
        {
            salleL.add(new JLabel(salles.get(i).getnom()));
//            salleCB.addItem(salles.get(i).getnom());
        }
        for(int i = 0 ; i < enseignants.size() ; i++)
        {
            enseignantL.add(new JLabel(enseignants.get(i).getnom()));
//            enseignantCB.addItem(enseignants.get(i).getnom());
        }
        for(int i = 0 ; i < groupe.size() ; i++)
        {
            groupeL.add(new JLabel(groupe.get(i).getnom()));
//            groupeCB.addItem(groupe.get(i).getnom());
        }



        date = new JSpinner();
        date.setModel(new SpinnerDateModel());
        date.setEditor(new JSpinner.DateEditor(date, "yyyy-MM-dd"));
        date.setValue(seance.getdate());
        
        
        heureD = new JComboBox<Integer>();
        duree = new JComboBox<Integer>();
        coursNom = new JComboBox<String>();
        coursType = new JComboBox<String>();
        valider = new JButton("modifier");
        valider.addActionListener(new ValiderListener());

        
        for(int d = 1; d < 8 ; d++)
        {
            heureD.addItem(d);
        }

        for(int f = 1 ; f < 8 ; f++)
        {
            duree.addItem(f);
        }
        heureD.setSelectedIndex(seance.getheure_debut()-1);
        duree.setSelectedIndex(seance.getduree()-1); 
        
        for(int i=0;i<cours.size();i++)
        {
        	coursNom.addItem(cours.get(i).getnom());
        	if(cours.get(i).getnom().equalsIgnoreCase(seance.getCour().getnom()))
        			{
        				coursNom.setSelectedIndex(i);
        			}
        }
        for(int i=0;i<type_cours.size();i++)
        {
        	coursType.addItem(type_cours.get(i).getsitenom());
        	if(  type_cours.get(i).getsitenom().equalsIgnoreCase(seance.gettypeCour().getsitenom()))
        	{
        		coursType.setSelectedIndex(i);
        	}
        }
        for(int i=0;i<seance.getEnseignants().size();i++)
        {
        	  //System.out.println(enseignantCB);
        	//System.out.println(seance+"  n"+seance.getEnseignants().get(i).getnom()+" i"+i);
        	enseignantCB.addItem(seance.getEnseignants().get(i).getnom());
        }
        for(int i=0;i<seance.getsalle().size();i++)
        {
        	salleCB.addItem(seance.getsalle().get(i).getnom());
        }
        for(int i=0;i<seance.getgroupes().size();i++)
        {
        	groupeCB.addItem(seance.getgroupes().get(i).getnom());
        }
        
        
        
        supSalle = new JButton("-");
        supEnseignant = new JButton("-");
        supGroupe = new JButton("-");
        addSalle = new JButton("+");
        addEnseignant= new JButton("+");
        addGroupe = new JButton("+");
        supSalle.addActionListener(new supSalleListener());
        supEnseignant.addActionListener(new supEnseignantListener());
        supGroupe.addActionListener(new supGroupeListener());
        addEnseignant.addActionListener(new ajouterEnseignantsListener());
        addGroupe.addActionListener(new ajouterGroupesListener());
        addSalle.addActionListener(new ajouterSallesListener());


        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

//
        outil = new Outil();
////
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p1.setLayout(new GridLayout(6,2,1,10));
        p1.add(dateL);
        p1.add(date); //
        p1.add(heureDL);
        p1.add(heureD); //
        p1.add(dureeL);
        p1.add(duree); //
        p1.add(coursNomL);
        p1.add(coursNom); //
        p1.add(coursTypeL);
        p1.add(coursType); //
        p1.add(valider);


 //       p2.setLayout(new GridLayout(1,salles.size(),1,10));
        p2.add(new JLabel(" "));
//        for(JLabel s : salleL)
//        {
//            p2.add(s);
//        }

 //       p3.setLayout(new GridLayout(1,enseignants.size(),1,10));
        p3.add(new JLabel(" "));
//        for(JLabel e : enseignantL)
//        {
//            p3.add(e);
//        }

//        p4.setLayout(new GridLayout(1,groupe.size(),1,10));
        p4.add(new JLabel(" "));
//        for(JLabel g : groupeL)
//        {
//            p4.add(g);
//        }

        JPanel p5 = new JPanel();
        p5.setLayout(new GridLayout(3,4,1,10));
        p5.add(supSalle);
        p5.add(new JLabel("salle: "));
        p5.add(salleCB);
        p5.add(addSalle);
        p5.add(supEnseignant);
        p5.add(new JLabel("enseignant: "));
        p5.add(enseignantCB);
        p5.add(addEnseignant);
        p5.add(supGroupe);
        p5.add(new JLabel("groupe: "));
        p5.add(groupeCB);
        p5.add(addGroupe);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        add(p);
        this.setVisible(true);
    }
    private void actualiser()
    {
    	wall.actual(new ModifSeanceDisplay(Integer.toString(seance.getidseance()), wall));
    }
    
    private class ValiderListener implements ActionListener
    {
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
        {
        	
        		InsertBDD insertBDD= new InsertBDD();
        		Integer hd = (Integer) heureD.getSelectedItem();
        		Integer du =  (Integer)   duree.getSelectedItem();
        		java.util.Date da= (java.util.Date) date.getValue();
        	    if(hd.intValue()+du.intValue()>=8||da.getDay()==0)
                {
                	new Error();
                }
        	    else
        	    {
        	    	insertBDD.updateSeance(seance.getidseance(), new Date(da.getYear(), da.getMonth(), da.getDate()), hd.intValue() ,du.intValue(), cours.get(coursNom.getSelectedIndex()).getID(), type_cours.get(coursType.getSelectedIndex()).getID());
        	    	new Succes();
        	    	actualiser();
        	    }
        }
    }
    // SUPPRESSION A BlIND
    private class supSalleListener implements ActionListener
    {
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
        {
        	DeleterBDD deleterBDD=new DeleterBDD();
        	if (salleCB.getItemCount()<=0)
        	{
        		new Error();
        	}
        	else {
        		deleterBDD.suppSeanceSalle(seance.getsalle().get(salleCB.getSelectedIndex()).getid());
        		new Succes();
        		actualiser();
			}
        }
    }
    
    private class supEnseignantListener implements ActionListener
    {
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
        {
        	DeleterBDD deleterBDD=new DeleterBDD();
        	if(enseignantCB.getItemCount()<=0)
        	{
        	 new Error();
        	}
        	else {
        		deleterBDD.suppSeanceEnseignant(seance.getEnseignants().get(enseignantCB.getSelectedIndex()).getID());
        		new Succes();
        		actualiser();
			}
        }
    }
    
    private class supGroupeListener implements ActionListener
    {
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
        {
        	DeleterBDD deleterBDD=new DeleterBDD();
        	if (groupeCB.getItemCount()<=0) {
				new Error();
			}
        	else
        	{
        		deleterBDD.suppSeanceGroupe(seance.getgroupes().get(groupeCB.getSelectedIndex()).getid());
        		new Succes();
        		actualiser();
        	}
         }
    }
    
    private class ajouterGroupesListener implements ActionListener
    {
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
        {
        	Integer hd = (Integer) heureD.getSelectedItem();
    		Integer du =  (Integer)   duree.getSelectedItem();
    		java.util.Date da= (java.util.Date) date.getValue();
        	ArrayList<Groupe> availableGroupes=new ArrayList<Groupe>();
        	for(int i=hd.intValue(); i<du.intValue()+hd.intValue();i++ )
        	{
              	availableGroupes.addAll(outil.avalaibleGroupe(new Date(da.getYear(), da.getMonth(), da.getDate()),i));
        	}
          	new AjouterGroupes(seance.getidseance(),availableGroupes,wall);
        }
    }
    
    private class ajouterEnseignantsListener implements ActionListener
    {
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
        {
        	Integer hd = (Integer) heureD.getSelectedItem();
    		Integer du =  (Integer)   duree.getSelectedItem();
    		java.util.Date da= (java.util.Date) date.getValue();
        	ArrayList<Enseignant> availableEnseignant=new ArrayList<Enseignant>();
        	System.out.println("date ajouter enseignant bouton "+ da.getDate());
        	for(int i=hd.intValue(); i<du.intValue()+hd.intValue();i++ )
        	{
              	availableEnseignant.addAll(outil.avalaibleEnseignants(new Date(da.getYear(), da.getMonth(), da.getDate()),i));
        	}

        	new AjouterEnseignant(seance.getidseance(),availableEnseignant,wall);
        }
    }
    
    private class ajouterSallesListener implements ActionListener
    {
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
        {
        	Integer hd = (Integer) heureD.getSelectedItem();
    		Integer du =  (Integer)   duree.getSelectedItem();
    		java.util.Date da= (java.util.Date) date.getValue();
        	ArrayList<Salle> availableSalles=new ArrayList<Salle>();
        	for(int i=hd.intValue(); i<du.intValue()+hd.intValue();i++ )
        	{
              	availableSalles.addAll(outil.avalaibleSalle(new Date(da.getYear(), da.getMonth(), da.getDate()),i));
        	}
        	new AjouterSalle(seance.getidseance(),availableSalles,wall);
        }
    }
}