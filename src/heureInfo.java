import javax.swing.*;
import java.awt.*;

public class heureInfo extends JPanel
{
    private JLabel heureDebut;
    private JLabel heureFin;

    private int idrdv;//
    heureInfo(int iD)
    {
        //  this.setLayout(new BorderLayout());
        idrdv=iD;
        heureDebut = new JLabel("debut");// recup info via idrdv
        heureFin = new JLabel("fin");
        add(heureDebut);
        add(heureFin);
        //add(doc,BorderLayout.WEST);
        //add(lieux,BorderLayout.CENTER);
        //add(date,BorderLayout.EAST);
        this.setVisible(true);
        this.validate();
    }
}