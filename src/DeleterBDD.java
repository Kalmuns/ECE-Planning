import java.sql.*;
import java.util.ArrayList;


public class DeleterBDD {
	private Connection conn=null;
	public DeleterBDD()
	{
		String url = "jdbc:mysql://localhost:3306/planning?autoReconnect=true&useSSL=false";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		 try {
			 conn = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void suppUtilisateur()
	{
		
	}
	public void suppCours()
	{
		
	}
	public void suppEnseignant()
	{
		
	}
	public void suppEtudiant()
	{
		
	}
	public void suppGroupe()
	{
		
	}
	public void suppPromotion()
	{
		
	}
	public void suppSalle()
	{
		
	}
	public void suppSeance()
	{
		
	}
	public void suppSite()
	{
		
	}
	public void suppTypeCour()
	{
		
	}
}
