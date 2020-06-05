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
	
	public void suppUtilisateurbyID(int id)
	{
		String query="DELETE  FROM utilisateur WHERE utilisateur_ID = ";
		query+= Integer.toString(id);
			try {
			     conn.createStatement().executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		query="DELETE  FROM etudiant WHERE etudiant_ID = ";
		query+= Integer.toString(id);
				try {
				     conn.createStatement().executeUpdate(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		query="DELETE  FROM enseignant WHERE enseignant_ID = ";
		query+= Integer.toString(id);
						try {
						     conn.createStatement().executeUpdate(query);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		query="DELETE  FROM seanceEnseignants_SeanceID WHERE seanceEnseignants_EnseignantsID = ";
		query+= Integer.toString(id);
						try {
							conn.createStatement().executeUpdate(query);
						} catch (SQLException e) {
											// TODO Auto-generated catch block
							e.printStackTrace();
						}
	}
	public void suppCoursbyID(int id)
	{
		String query="DELETE  FROM cours WHERE cours_ID = ";
		query+= Integer.toString(id);
			try {
			     conn.createStatement().executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 query="DELETE  FROM seance WHERE seance_CoursID = ";
			query+= Integer.toString(id);
				try {
				     conn.createStatement().executeUpdate(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace()	;
				}
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
	public void suppSeance(int id)
	{
		String query="DELETE  FROM seance WHERE seance_ID = ";
		query+= Integer.toString(id);
			try {
			     conn.createStatement().executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 query="DELETE  FROM seancesalles WHERE seanceSalles_SeanceIDID = ";
			query+= Integer.toString(id);
				try {
				     conn.createStatement().executeUpdate(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     query="DELETE  FROM seanceenseignants WHERE seanceEnseignants_SeanceID = ";
				query+= Integer.toString(id);
					try {
					     conn.createStatement().executeUpdate(query);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 query="DELETE  FROM seancegroupes WHERE seanceGroupes_SeanceID = ";
					query+= Integer.toString(id);
						try {
						     conn.createStatement().executeUpdate(query);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
	// SEANCE SALLE/ENSEIGNANT/GROUPE TO SUPP 
	}
	public void suppSite()
	{
		
	}
	public void suppTypeCour()
	{
		
	}
}
