import javax.swing.*;
import java.awt.*;

public class WallCalendrier extends JPanel
{
    private int[] idpersonne;
    private Calendrier calendrier;
    private SemaineDisplay semaineDisplay;
    
    Utilisateur user;
    public WallCalendrier()
    {
    	
        this.setLayout(new BorderLayout());
        DAO dao= new DAO();
        user= dao.getUtilisateurbyID(1);
//        JPanel buffer= new Login(this,idpersonne);
//        add(buffer,BorderLayout.CENTER);
//        buffer=new Menu(this);
//        add(buffer,BorderLayout.NORTH);
        add(new SemaineDisplay(this,0),BorderLayout.NORTH);
        add(new Calendrier(2,user),BorderLayout.CENTER);
        //add(new AffichageSalleLibre(1), BorderLayout.CENTER);
        
        
        
    }
    //Le createur des Salles Libres
    public WallCalendrier(int i, int j)
    {
    	
        this.setLayout(new BorderLayout());
        DAO dao= new DAO();
        user= dao.getUtilisateurbyID(1);
//        JPanel buffer= new Login(this,idpersonne);
//        add(buffer,BorderLayout.CENTER);
//        buffer=new Menu(this);
//        add(buffer,BorderLayout.NORTH);
        add(new AffichageSalleLibre(2),BorderLayout.CENTER);
        add(new SemaineDisplay(this,1),BorderLayout.NORTH);
        //add(new Calendrier(2,user),BorderLayout.CENTER);
        //add(new AffichageSalleLibre(1), BorderLayout.CENTER);
        
        
        
    }
    public WallCalendrier(int i)
    {
    	DAO dao= new DAO();
        user= dao.getUtilisateurbyID(1);
        this.setLayout(new BorderLayout());
        // Appeler la page Login

//        JPanel buffer= new Login(this,idpersonne);
//        add(buffer,BorderLayout.CENTER);
//        buffer=new Menu(this);
//        add(buffer,BorderLayout.NORTH);
			
        add(new SemaineDisplay(this,0),BorderLayout.NORTH);
        add(new Calendrier(i,user),BorderLayout.CENTER);
        

    }
    
    protected void actualCalendrier(int y)
    {
    	DAO dao= new DAO();
        user= dao.getUtilisateurbyID(1);
    	int i;
    	for (i=0;i<this.getComponentCount();i++)
        {
            this.remove(i);
       }
    this.removeAll();
       this.update(this.getGraphics());
        this.revalidate();
        paint(this.getGraphics());
        add(new SemaineDisplay(this,0),BorderLayout.NORTH);
        add(new Calendrier(y,user),BorderLayout.CENTER);
       
       
       
     this.update(this.getGraphics());
      this.revalidate();
      
    }
    
    //Le actualCalendrier pour les Salles Libres
    protected void actualCalendrier(int y,int j)
    {
    	DAO dao= new DAO();
        user= dao.getUtilisateurbyID(1);
    	int i;
    	for (i=0;i<this.getComponentCount();i++)
        {
            this.remove(i);
       }
    this.removeAll();
       this.update(this.getGraphics());
        this.revalidate();
        paint(this.getGraphics());
        add(new SemaineDisplay(this,1),BorderLayout.NORTH);
        add(new AffichageSalleLibre(y),BorderLayout.CENTER);
       
       
       
     this.update(this.getGraphics());
      this.revalidate();
      
    }
}
