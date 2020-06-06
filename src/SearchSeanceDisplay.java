import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SearchSeanceDisplay extends JPanel
{
    private JLabel jour;
    private JLabel mois;
    private JLabel annee;
    private JLabel dateL;
    private JLabel heureDL;
    private JLabel heureFL;
    private JComboBox<Integer> j;
    private JComboBox<Integer> m;
    private JComboBox<Integer> a;
    private JComboBox <Integer> semaine;
    private JComboBox <Integer> heureD;
    private JComboBox heureF;
    private JComboBox combo;
    protected  JButton valider;
    WallSeancegrid wallSeancegrid=null;

    public SearchSeanceDisplay(WallSeancegrid wall)
    {
        jour = new JLabel("  jour :");
        mois = new JLabel("  mois :");
        annee = new JLabel("  annee :");
        j=new JComboBox<Integer>();
        m=new JComboBox<Integer>();
        a= new JComboBox<Integer>();
        
        heureDL = new JLabel("  heure de début :");
        heureFL = new JLabel("  durée du cours:");
        heureD = new JComboBox<Integer>();
        heureF=new JComboBox<Integer>();
        valider = new JButton("  Cherchez");
        valider.addActionListener(new validerListener());
        this.wallSeancegrid=wall;
        heureD = new JComboBox();
        for(int d = 1 ; d < 21 ; d++)
        {
            heureD.addItem(d);
        }
        heureF = new JComboBox();
        for(int f = 1 ; f < 21 ; f++)
        {
            heureF.addItem(f);
        }
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
        //a.addItem(0000);
   
        add(jour);
        add(j);
        add(mois);
        add(m);
        add(annee);
        add(a);
        add(heureDL);
        add(heureD);
        add(heureFL);
        add(heureF);
        add(valider);

        this.setVisible(true);
        this.validate();
    }

    private class validerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	DAO dao=new DAO();
        	Outil outil=new Outil();
        	ArrayList<Seance> seances=new ArrayList<Seance>();
        	Integer an= (Integer) a.getSelectedItem();
        	an=an.intValue()-1900;
        	Integer mo=(Integer) m.getSelectedItem();
        	Integer joInteger =(Integer) j.getSelectedItem();
        	Integer hDInteger =(Integer) heureD.getSelectedItem();
        	Integer hFInteger= (Integer) heureF.getSelectedItem();
        	@SuppressWarnings("deprecation")
        
			java.sql.Date date= new java.sql.Date(an.intValue(),mo.intValue()-1,joInteger.intValue());
        	for(int i=0;i<hFInteger.intValue();i++)
        	{
        		seances.addAll(outil.searchSeancebyDateHoure(date, hDInteger.intValue()+i));
        	}
//        	seances.add(dao.getSeancebyID(1));
//        	seances.add(dao.getSeancebyID(1));
//        	seances.add(dao.getSeancebyID(1));
        	System.out.print("salle trouver :"+seances.size()+ "DATE "+date);
        	wallSeancegrid.displaygrid(seances);
        }
    }
}
