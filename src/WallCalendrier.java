import javax.swing.*;
import java.awt.*;

public class WallCalendrier extends JPanel
{
    private int[] idpersonne;
    public WallCalendrier()
    {
        this.setLayout(new BorderLayout());
        // Appeler la page Login

//        JPanel buffer= new Login(this,idpersonne);
//        add(buffer,BorderLayout.CENTER);
//        buffer=new Menu(this);
//        add(buffer,BorderLayout.NORTH);
//
        add(new SemaineDisplay(),BorderLayout.NORTH);
        add(new Calendrier(),BorderLayout.CENTER);
        add(new HeureDisplay(),BorderLayout.WEST);

    }
}
