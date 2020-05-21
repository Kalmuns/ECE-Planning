import javax.swing.*;
import java.awt.*;

public class heuresJour extends JPanel
{
    private Wall wall;
    private int idrdv;
    //private ArrayList<Doctor> doc  // utilisation des classes quand on mettra sql
    public heuresJour(int id)
    {
        System.out.println("page heuresJour");
        idrdv=id;
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        //add(new MeetingCaseInfo(idrdv),BorderLayout.CENTER);
        // ajouter condition d'affichage pour l'admin
//        add(new heureInfo(idrdv),BorderLayout.WEST);
        add(new heureInfo(idrdv));

        validate();
    }
}
