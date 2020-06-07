import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RechercheSeanceDisplay extends JPanel
{
    protected JLabel rechercheL;
    protected JTextField rechercheTA;
    protected JButton rechercheB;
    public RechercheSeanceDisplay()
    {

        rechercheL = new JLabel("Recherche: ");
        rechercheTA = new JTextField(20);
        rechercheB = new JButton("rechercher");
        rechercheB.addActionListener(new RechercheButton());

        add(rechercheL);
        add(rechercheTA);
        add(rechercheB);
    }

    private class RechercheButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String res = rechercheTA.getText().trim();
            //System.out.println(res);

        }
    }

}
