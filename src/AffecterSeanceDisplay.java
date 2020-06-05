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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AffecterSeanceDisplay extends JPanel
{
    private JLabel semaineL;
    private JLabel dateL;
    private JLabel heureDL;
    private JLabel heureFL;
    private JComboBox <Integer> semaine;
    private JComboBox date;
    private JComboBox <Integer> heureD;
    private JComboBox heureF;
    private JComboBox combo;
    protected  JButton valider;


    /*
    private Calendar cal;
    DefaultComboBoxModel j = new DefaultComboBoxModel();
    JComboBox jour = new JComboBox(j);
    DefaultComboBoxModel m = new DefaultComboBoxModel();
    JComboBox mois = new JComboBox(m);
*/


    public AffecterSeanceDisplay()
    {
        semaineL = new JLabel("semaine :");
        dateL = new JLabel("date :");
        heureDL = new JLabel("heure de début :");
        heureFL = new JLabel("durée du cours:");
        semaine = new JComboBox<>();
        heureD = new JComboBox();
        valider = new JButton("Valider");
        valider.addActionListener(new validerListener());

        for (int s = 1 ; s < 16 ; s++)
        {
            semaine.addItem(s);
        }
        heureD = new JComboBox();
        for(int d = 8 ; d < 21 ; d+=2)
        {
            heureD.addItem(d);
        }
        heureF = new JComboBox();
        for(int f = 8 ; f < 21 ; f+=2)
        {
            heureF.addItem(f);
        }


    /*
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.MONTH, month);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int v = 1; v <= maxDay; v++) {
            j.addElement(Integer.valueOf(v));
        }
        j.setSelectedItem(Integer.valueOf(day));

        for(int i = 0 ; i < 15 ; i++)
        {
            semaine.addItem(i);
        }*/

        add(semaineL);
        add(semaine);
//        add(dateL);
//        add(date);
        add(heureDL);
        add(heureD);
        add(heureFL);
        add(heureF);
        add(valider);
        /* this.add(combo, BorderLayout.NORTH);
         * */
        this.setVisible(true);
        this.validate();
    }

    private class validerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String seamaineRes = semaine.getSelectedItem().toString();
            System.out.println(seamaineRes);
        }
    }
}
