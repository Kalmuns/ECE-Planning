import javax.swing.*;
import java.awt.*;

/**
 * Contient Semaine Display et Calendrier
 * Contient des constructeer passer en parametre de wall appeler dans semaine display
 * @author Kalmuns
 *
 */

public class WallCalendrier extends JPanel
{
    private int[] idpersonne;
    private Calendrier calendrier;
    private SemaineDisplay semaineDisplay;
    
    Utilisateur user;
    public WallCalendrier(int users)
    {
    	
        this.setLayout(new BorderLayout());
        DAO dao= new DAO();
        user= dao.getUtilisateurbyID(users);
//        JPanel buffer= new Login(this,idpersonne);
//        add(buffer,BorderLayout.CENTER);
//        buffer=new Menu(this);
//        add(buffer,BorderLayout.NORTH);
        add(new SemaineDisplay(this,0,0),BorderLayout.NORTH);
        add(new Calendrier(2,user,this,0,0),BorderLayout.CENTER);
        //add(new AffichageSalleLibre(1), BorderLayout.CENTER);
        
        
        
    }
    //Le createur des Salles Libres
    public WallCalendrier(int i, String buffer)
    {
    	
        this.setLayout(new BorderLayout());
        DAO dao= new DAO();
        user= dao.getUtilisateurbyID(1);
//        JPanel buffer= new Login(this,idpersonne);
//        add(buffer,BorderLayout.CENTER);
//        buffer=new Menu(this);
//        add(buffer,BorderLayout.NORTH);
        add(new AffichageSalleLibre(2),BorderLayout.CENTER);
        add(new SemaineDisplay(this,1,0),BorderLayout.NORTH);
        //add(new Calendrier(2,user),BorderLayout.CENTER);
        //add(new AffichageSalleLibre(1), BorderLayout.CENTER);
        
        
        
    }
    public WallCalendrier(int semaine,int users)
    {
    	DAO dao= new DAO();
        user= dao.getUtilisateurbyID(users);
        this.setLayout(new BorderLayout());
        // Appeler la page Login

//        JPanel buffer= new Login(this,idpersonne);
//        add(buffer,BorderLayout.CENTER);
//        buffer=new Menu(this);
//        add(buffer,BorderLayout.NORTH);
			
        add(new SemaineDisplay(this,0,0),BorderLayout.NORTH);
        add(new Calendrier(semaine,user,this,0,0),BorderLayout.CENTER);
        

    }
    //Le actualCalendrier pour les Salles Libres
    protected void actualCalendrier(int semaine)
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
        add(new SemaineDisplay(this,1,0),BorderLayout.NORTH);
        add(new AffichageSalleLibre(semaine),BorderLayout.CENTER);
       
       
       
     this.update(this.getGraphics());
      this.revalidate();
      
    }
    
   
    protected void actualCalendrier(int semaine,int users)
    {
    	DAO dao= new DAO();
        user= dao.getUtilisateurbyID(users);
    	int i;
    	for (i=0;i<this.getComponentCount();i++)
        {
            this.remove(i);
       }
    this.removeAll();
       this.update(this.getGraphics());
        this.revalidate();
        paint(this.getGraphics());
        add(new SemaineDisplay(this,0,0),BorderLayout.NORTH);
        add(new Calendrier(semaine,user,this,0,0),BorderLayout.CENTER);
       
       
     this.update(this.getGraphics());
      this.revalidate();
      
    }
    //Actual pour les Nom des seances
    protected void actualCalendrier(int semaine,int mode , int contenu,int users)
    {
    	DAO dao= new DAO();
        user= dao.getUtilisateurbyID(users);
    	int i;
    	for (i=0;i<this.getComponentCount();i++)
        {
            this.remove(i);
       }
    	this.removeAll();
       this.update(this.getGraphics());
        this.revalidate();
        paint(this.getGraphics());
        add(new SemaineDisplay(this,mode,contenu),BorderLayout.NORTH);
        add(new Calendrier(semaine,user,this,mode,contenu),BorderLayout.CENTER);
       
       
       
     this.update(this.getGraphics());
      this.revalidate();
      
    }
    public int getID() {
		return user.getID();
	}
}
