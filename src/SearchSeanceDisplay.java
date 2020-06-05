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

public class SearchSeanceDisplay extends JPanel
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
    WallSeancegrid wallSeancegrid=null;

    public SearchSeanceDisplay(WallSeancegrid wall)
    {
        semaineL = new JLabel("jour :");
        dateL = new JLabel("date :");
        heureDL = new JLabel("heure de début :");
        heureFL = new JLabel("durée du cours:");
        semaine = new JComboBox<>();
        heureD = new JComboBox();
        valider = new JButton("Valider");
        valider.addActionListener(new validerListener());
        this.wallSeancegrid=wall;
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


        add(semaineL);
        add(semaine);
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
        	
            String seamaineRes = semaine.getSelectedItem().toString();
            System.out.println(seamaineRes);
        }
    }
}
