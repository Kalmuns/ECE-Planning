import javax.swing.*;
import java.awt.*;

public class heuresJour extends JPanel
{
    private WallCalendrier wallCalendrier;
    private int heureD;
    //private ArrayList<Doctor> doc  // utilisation des classes quand on mettra sql
    public heuresJour(int heure)
    {
        System.out.println("page heuresJour");
        heureD=heure;
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        // ajouter condition d'affichage pour l'admin
//        add(new heureInfo(heureD),BorderLayout.WEST);
        add(new heureInfo(heureD));

        validate();
    }
}
