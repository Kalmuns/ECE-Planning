
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Outil {
	//public int semaine;
	public  Outil()
	{
	}
	
	public int convertirSemaine(java.sql.Date dates)
	{
		//On utilise Calendar pour convertir le date sql en valeur facile a manipuler
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dates);
	    return cal.get(Calendar.WEEK_OF_YEAR);
	}
	public String convertirJour(java.sql.Date dates)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(dates);
		
	    switch(cal.get(Calendar.DAY_OF_WEEK))
	    {
	    case 1: return "Lundi";
	    		
	    case 2: return "Mardi";
	    		
	    case 3: return "Mercredi";
	    		
	    case 4: return "Jeudi";
	    		
	    case 5: return "Vendredi";
	    		
	    case 6: return "Samedi";
	    		
	    case 7: return "Dimanche";
	    		
	    default: return "Invalid";
	    		
	    
	    
	    }
	  
	    
	}
	
	public ArrayList<Seance> rechercheseance(String recherche)
	{
		ArrayList<Seance> seances= new ArrayList<Seance>();
		
		return seances;
	}
}

