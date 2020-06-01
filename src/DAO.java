import java.sql.*;
import java.util.ArrayList;




public class DAO {
		
	private Connection conn=null;
	
	public DAO(){
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
	
	public Utilisateur getUtilisateurbyID(int utilisateurID)
	{
		Utilisateur user =null;
		String query="SELECT * FROM utilisateur WHERE utilisateur_ID = ";
		query+= Integer.toString(utilisateurID);
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {
					  user = new Utilisateur(result.getInt("utilisateur_ID"), result.getString("utilisateur_Email"), result.getString("utilisateur_Password"), result.getString("utilisateur_Nom"), result.getString("utilisateur_Prenom"), result.getInt("utilisateur_Droit"));
					
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return user;
	}
	
	public ArrayList<Utilisateur> getUtilisateurByGroupID(int idgroup)
	{
		  String query="SELECT * FROM utilisateur WHERE utilisateur_ID IN (SELECT etudiant_ID FROM etudiant WHERE etudiant_Groupe= " ;
		  query += idgroup;
		  query += (")");
		  ArrayList<Utilisateur>  toreturn= new ArrayList<Utilisateur>();
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
		//	ResultSet result = conn.createStatement().executeQuery("SELECT * FROM etudiant");
				  while(result.next())
				  {
					  toreturn.add(new Utilisateur(result.getInt("utilisateur_ID"), result.getString("utilisateur_Email"), result.getString("utilisateur_Password"), result.getString("utilisateur_Nom"), result.getString("utilisateur_Prenom"), result.getInt("utilisateur_Droit")));
					  System.out.println(result.getInt("etudiant_ID"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return toreturn;
	}
	
	public Cour getCourbyID(int courID)
	{
		Cour cour=null;
		String query="SELECT DISTINCT * FROM cour WHERE coursid = ";
		query+= Integer.toString(courID);
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {
					  cour = new Cour(result.getInt("cours_ID"), result.getString("cours_Nom"));
					  
					
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cour;
	}
	
	
	
	
	
	
	
	
	
	
}
