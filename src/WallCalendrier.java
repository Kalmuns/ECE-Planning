import javax.swing.*;
import java.awt.*;

public class WallCalendrier extends JPanel
{
    private int[] idpersonne;
    private Calendrier calendrier;
    private SemaineDisplay semaineDisplay;
    private HeureDisplay heureDisplay;
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
        add(new Calendrier(2),BorderLayout.CENTER);
        add(new HeureDisplay(),BorderLayout.WEST);
        

    }
    public WallCalendrier(int i)
    {
        this.setLayout(new BorderLayout());
        // Appeler la page Login

//        JPanel buffer= new Login(this,idpersonne);
//        add(buffer,BorderLayout.CENTER);
//        buffer=new Menu(this);
//        add(buffer,BorderLayout.NORTH);
			System.out.println( "Bla");
        add(new SemaineDisplay(),BorderLayout.NORTH);
        add(new Calendrier(i),BorderLayout.CENTER);
        add(new HeureDisplay(),BorderLayout.WEST);

    }
    protected void actualCalendrier(int y)
    {
//    	int i;
//    	for (i=0;i<this.getComponentCount();i++)
//        {
//            this.remove(i);
//        }
//        this.update(this.getGraphics());
//        this.revalidate();
        add(new SemaineDisplay(),BorderLayout.NORTH);
        add(new Calendrier(y),BorderLayout.CENTER);
        add(new HeureDisplay(),BorderLayout.WEST);
//      this.update(this.getGraphics());
//      this.revalidate();

    }
}
