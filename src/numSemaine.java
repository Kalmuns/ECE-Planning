import javax.swing.*;
import java.awt.*;

public class numSemaine extends JPanel
{
    private Wall wall;
    private int idrdv;
    //private ArrayList<Doctor> doc  // utilisation des classes quand on mettra sql
    public numSemaine(int id)
    {
        System.out.println("page numSemaine");
        //wall=wa;
        idrdv=id;
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        // ajouter condition d'affichage pour l'admin
      add(new numSemaineButton(idrdv),BorderLayout.NORTH);
//        add(new numSemaineButton(idrdv));

        validate();
    }
}
