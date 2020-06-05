import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AffecterProfDisplay extends JPanel
{
    protected JLabel profL;
    protected JLabel seanceL;
    protected JLabel groupeL;
    protected JComboBox prof;
    protected JComboBox seance;
    protected  JComboBox groupe;
    protected JButton validerProf;
    protected JButton validerGroupe;


    public AffecterProfDisplay()
    {
        profL = new JLabel("choisir un professeur");
        seanceL = new JLabel("choisir une seance");
        groupeL = new JLabel("choisir un groupe");
        prof = new JComboBox();
        prof.setPrototypeDisplayValue("/////////////////////");
        seance = new JComboBox();
        seance.setPrototypeDisplayValue("/////////////////////");
        groupe = new JComboBox();
        groupe.setPrototypeDisplayValue("/////////////////////");
        validerProf = new JButton("Valider");
        // faire un while pour remplir Combobow
        validerProf.addActionListener(new validerProfListener());
        validerGroupe = new JButton("Affecter");
        validerGroupe.addActionListener(new validerGroupeListener());

        //this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        add(profL);
        add(prof);
        add(seanceL);
        add(seance);
        add(validerProf);

//        add(groupeL);
//        add(groupe);
//        add(seanceL);
//        add(seance);
//        add(validerGroupe);
        this.validate();
        setVisible(true);
    }

    private class validerProfListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            String profString = prof.getSelectedItem().toString();
            String seanceString = seance.getSelectedItem().toString();
            if(profString.isEmpty() || seanceString.isEmpty())
            {
                //JOptionPane.showMessageDialog(null, "remplir tout les champs");
            }

        }
    }

    private class validerGroupeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }


}
