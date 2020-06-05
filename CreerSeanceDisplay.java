import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CreerSeanceDisplay extends JPanel
{
    protected JLabel dateL;
    protected JLabel heureDL;
    protected JLabel dureeL;
    protected JLabel coursNomL;
    protected JLabel coursTypeL;
    protected DateFormat df;
    protected JFormattedTextField dateFormat;
    protected JComboBox date;
    protected JComboBox heureD;
    protected JComboBox duree;
    protected JComboBox coursNom;
    protected JComboBox coursType;
    protected JButton valider;



    public CreerSeanceDisplay()
    {
        dateL = new JLabel("date: ");
        heureDL = new JLabel("heure de début: ");
        dureeL = new JLabel("durée du cours: ");
        coursNomL = new JLabel("nom du cours: ");
        coursTypeL = new JLabel("type de cours: ");
        df = new SimpleDateFormat("dd MMM YYYY");
        dateFormat = new JFormattedTextField(df);
        date = new JComboBox();
        heureD = new JComboBox();
        duree = new JComboBox();
        coursNom = new JComboBox();
        coursType = new JComboBox();
        valider = new JButton("valider");
        heureD.addItem("8h30");
        heureD.addItem("10h15");
        heureD.addItem("12h00");
        heureD.addItem("13h45");
        heureD.addItem("15h30");
        heureD.addItem("17h15");
        heureD.addItem("19h00");

        coursType.addItem("interactif");
        coursType.addItem("magistral");
        coursType.addItem("TD");
        coursType.addItem("TP");
        coursType.addItem("projet");
        coursType.addItem("soutien");

        this.setLayout(new GridLayout(5,2,1,10));


        add(dateL);
        add(date);
        add(heureDL);
        add(heureD);
        add(dureeL);
        add(duree);
        add(coursNomL);
        add(coursNom);
        add(coursTypeL);
        add(coursType);

        this.setVisible(true);
    }
}
