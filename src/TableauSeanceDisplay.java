import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TableauSeanceDisplay extends JPanel
{
    protected JLabel rechercheL;
    protected JTextField rechercheTF;
    protected JButton rechercheB;
    //protected JButton test;
//    List<JPanel> panelList = new ArrayList<JPanel>();

//    protected ArrayList<Seance> seances;
//    protected JTable table;
//    protected DAO dao;
//    protected JPanel p;
//    protected DefaultTableModel tm;

    public TableauSeanceDisplay()
    {


//        dao = new DAO();
//        p = new JPanel();
        //seances = dao.getallseancebyweek();
//        seances =dao.getSeancesByWeek(1, semaine);
//
//        table = new JTable();
        rechercheL = new JLabel("Recherche: ");
        rechercheTF = new JTextField(20);
        rechercheB = new JButton("rechercher");
        rechercheB.addActionListener(new RechercheButton());
        add(new InitSearchField(rechercheTF,rechercheB),BorderLayout.NORTH);
        add(rechercheL);
        add(rechercheTF);
        add(rechercheB);
//        add(p);
        //add(tableau);



        this.setVisible(true);



    }
    private class RechercheButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
//            String res = rechercheTA.getText();
//            System.out.println(res);
//            dao.getSeancebyID(Integer.parseInt(res));
//            for(int i=0;i<seances.size();i++)
//            {
////                p.add(new SeanceDisplay(seances.get(0)));
//                panelList.add(new SeanceDisplay(seances.get(Integer.parseInt(res))));
//            }
            add(new SeanceDisplay(rechercheTF.getText()),BorderLayout.CENTER);
            revalidate();
        }
    }

    private class InitSearchField extends JPanel
    {
        private JTextField searchfield;
        private JButton search;
        InitSearchField(JTextField bufferfield, JButton bufferbutton)
        {
//            search=bufferbutton;
//            searchfield=bufferfield;
//            add(searchfield);
//            add(search);
            //System.out.println("testtestetst");
        }
    }
}
