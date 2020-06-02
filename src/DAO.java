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
	
	
	//return un utilisateur par id 
	public Utilisateur getUtilisateurbyID(int utilisateurID)
	{
		Enseignant enseignant= null;
		Etudiant etudiant=null;
		Utilisateur user =null;
		String query="SELECT * FROM utilisateur WHERE utilisateur_ID = ";
		query+= Integer.toString(utilisateurID);
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {  
					  user = new Utilisateur(result.getInt("utilisateur_ID"), result.getString("utilisateur_Email"), result.getString("utilisateur_Password"), result.getString("utilisateur_Nom"), result.getString("utilisateur_Prenom"), result.getInt("utilisateur_Droit"));
					// Ruben souviens toi que une query dans une query tu l'as pas tester si ça bug ici reporte ce qu'il y'a ici un peu plus bas et passe les donné par user
					  // si enseignant 
				
					  try {
							    ResultSet resultenseignant= null;
							    		resultenseignant=conn.createStatement().executeQuery(new String("SELECT * FROM enseignant WHERE EXISTS (SELECT * FROM enseignant WHERE enseignant_ID="+user.getID()+")"));
								  while(resultenseignant.next())
								  {  
									  if(resultenseignant!=null)
									  {
									  	enseignant = new Enseignant(result.getInt("utilisateur_ID"), result.getString("utilisateur_Email"), result.getString("utilisateur_Password"), result.getString("utilisateur_Nom"), result.getString("utilisateur_Prenom"), result.getInt("utilisateur_Droit"),resultenseignant.getInt("enseignant_CoursID"));
									  	return enseignant;
									  }	
								  }
								  
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					  // le met en tant qu'étudiant si s'en est un 
					  try {
						    ResultSet resultetudiant= null;
						    		resultetudiant=conn.createStatement().executeQuery(new String("SELECT * FROM etudiant WHERE EXISTS (SELECT * FROM etudiant WHERE etudiant_ID="+user.getID()+")"));
							  while(resultetudiant.next())
							  {  
								  if(resultetudiant!=null)
								  {
								  	etudiant = new Etudiant(result.getInt("utilisateur_ID"), result.getString("utilisateur_Email"), result.getString("utilisateur_Password"), result.getString("utilisateur_Nom"), result.getString("utilisateur_Prenom"), result.getInt("utilisateur_Droit"),resultetudiant.getInt("etudiant_numero"),resultetudiant.getInt("etudiant_Groupe"));
								  	return etudiant;
								  }	
							  }
							  
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  }
				  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return user;
	}
	
	
	// ne renvoie pas le group???? 
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
	
	public Groupe getGroupebyID()
	{
		Groupe groupe=null;
		
		
		return groupe;
	}
	
	
	
	
	
	
	
	
}
