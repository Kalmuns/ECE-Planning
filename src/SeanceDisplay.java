import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeanceDisplay extends JPanel
{
    private Wall w;
    private ArrayList<Seance> seances;
    private DAO dao;
    private ArrayList<JButton> modifSeance;

    public SeanceDisplay(String search)
    {
        //System.out.println("seance display");
        seances = new ArrayList<>();
        dao = new DAO();
        seances = dao.getSeancesByWeek(1, Integer.parseInt(search));

        this.setLayout(new GridLayout(10,seances.size(),10,10)); //nb ligne à modifer
        for(int i = 0; i < seances.size() ; i++ )
        {

        }

    }
    private void accesPageModif()
    {
        for (int i=0;i<seances.size();i++)
        {
            modifSeance.add(new JButton("modif"));
            modifSeance.get(i).setName(Integer.toString(seances.get(i).getidseance()));
            modifSeance.get(i).addActionListener(new ModifSeanceDisplayListener());
        }
    }

    private class ModifSeanceDisplayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //get id doc
         //   ModifSeanceDisplay  mds = new ModifSeanceDisplay();

            // constructeur fiche doc(id)
         //   w.actual(mds);

        }

    }
}
