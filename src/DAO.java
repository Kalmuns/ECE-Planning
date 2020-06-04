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
	//Renvoies les utilisateurs du groupe.
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
	
	// retourne le cour
	public Cour getCourbyID(int courID)
	{
		Cour cour=null;
		String query="SELECT DISTINCT * FROM cours WHERE cours_ID = ";
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
	
	//retourne le groupe 
	public Groupe getGroupebyID(int groupeID)
	{
		Groupe groupe=null;
		String query="SELECT DISTINCT * FROM groupe WHERE groupe_ID = ";
		query+= Integer.toString(groupeID);
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {
					  groupe = new Groupe(result.getInt("groupe_ID"),result.getString("groupe_Nom"),result.getInt("groupe_PromotionID"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return groupe;
	}
	
	//Retourne la salle
	public Salle getSallebyID(int salleID)
	{
		Salle salle=null;
		String query="SELECT DISTINCT * FROM salle WHERE salle_ID = ";
		query+= Integer.toString(salleID);
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {
					  salle = new Salle(result.getInt("salle_ID"),result.getString("salle_Nom"),result.getInt("salle_Capacite"),result.getInt("salle_SiteID"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return salle;
	}
	
	// Return le site 
	public Site getSitebyID(int SiteID)
	{
		Site site=null;
		String query="SELECT DISTINCT * FROM site WHERE site_ID = ";
		query+= Integer.toString(SiteID);
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {
					  site = new Site(result.getInt("site_ID"),result.getString("site_Nom"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return site;
	}
	
	//retourne le cour
	public TypeCour getTypeCourbyID(int courid) {
		TypeCour typeCour=null;
		String query="SELECT DISTINCT * FROM typecours WHERE typeCours_ID = ";
		query+= Integer.toString(courid);
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {
					  typeCour = new TypeCour(result.getInt("typeCours_ID"),result.getString("typeCours_Nom"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return typeCour;
		
	}
	
	
	
	
	// On remplit la seance 
	public Seance getSeancebyID(int seanceID)
	{
		DAO dao=new DAO();
		int i;
		Seance seance=null;
		ArrayList<Enseignant> enseignants=new ArrayList<Enseignant>();
		ArrayList<Groupe> groupes=new ArrayList<Groupe>();
		ArrayList<Salle> salles=new ArrayList<Salle>();
		ArrayList<Integer> tableaux = new ArrayList<Integer>();
		
		//   -- ENSEIGNANTS 
		// On remplit d'abord eseignants 
		String query="SELECT DISTINCT * FROM seanceenseignants WHERE seanceEnseignants_SeanceID = ";
		query+= Integer.toString(seanceID);
			try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {
					tableaux.add(result.getInt("seanceEnseignants_EnseignantsID"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	//Ajoute les enseignants.
		 	for( i=0;i<tableaux.size();i++)
		 	{
		 		enseignants.add((Enseignant) dao.getUtilisateurbyID(tableaux.get(i).intValue()));
		 	}
		 	
		 	// --GROUPES
		 	
		 // Ajouts des groupes.
		 tableaux = new ArrayList<Integer>();
		 query="SELECT DISTINCT * FROM seancegroupes WHERE 	seanceGroupes_SeanceID = ";
		 query+= Integer.toString(seanceID);
			try {
			    ResultSet result= conn.createStatement().executeQuery(query);
				  while(result.next())
				  {
					tableaux.add(result.getInt("seanceGroupes_GroupeID"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	for( i=0;i<tableaux.size();i++)
		 	{
		 		groupes.add((Groupe) dao.getGroupebyID(tableaux.get(i).intValue()));
		 	}
		 
		 	
		 	  //--SALLE
		 // Ajouts des Salles
		 	 tableaux = new ArrayList<Integer>();
			 query="SELECT DISTINCT * FROM seancesalles WHERE 	seanceSalles_SeanceIDID = ";
			 query+= Integer.toString(seanceID);
				try {
				    ResultSet result= conn.createStatement().executeQuery(query);
					  while(result.next())
					  {
						tableaux.add(result.getInt("seanceSalles_SalleID"));
					  }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 	for( i=0;i<tableaux.size();i++)
			 	{
			 		salles.add((Salle) dao.getSallebyID(tableaux.get(i).intValue()));
			 	}
		 // Recuperation du reste de la seance
			 
			 query=	"SELECT * FROM seance WHERE seance_ID =";
			 query+=Integer.toString(seanceID);
			 try {
				    ResultSet result= conn.createStatement().executeQuery(query);
					  while(result.next())
					  {
						seance= new Seance(groupes, enseignants, salles, result.getInt("seance_ID"), result.getDate("seance_Date"), result.getInt("seance_HeureDebut"), result.getInt("seance_HeureFin"), result.getInt("seance_Etat"), result.getInt("seance_Semaine"), dao.getCourbyID(result.getInt("seance_CoursID")), dao.getTypeCourbyID(result.getInt("seance_TypeCoursID")));
					  }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 	
		return seance;
	}
	
	public ArrayList<Seance> getSeancesByWeek(int userid,int semaine) {
		ArrayList<Seance> seances=new ArrayList<Seance>();
		DAO dao=new DAO();
		String query="SELECT * FROM enseignant WHERE enseignant_ID=";
		query+=Integer.toString(userid);
		
		 try {
			    ResultSet result= conn.createStatement().executeQuery(query);
			 // SI ID ENSEIGNANT
			    if(result.next()){
			    	query="SELECT DISTINCT * FROM seance INNER JOIN seanceenseignants ON seance_ID=seanceEnseignants_SeanceID WHERE seance.seance_Semaine= ";
					query+= Integer.toString(semaine);
					query+= "    AND seanceEnseignants_EnseignantsID=";
					query+= Integer.toString(userid);
					 try {
						     result= conn.createStatement().executeQuery(query);
							  while(result.next())
							  {
								  seances.add(dao.getSeancebyID(result.getInt("seance_ID")));
							  }
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

			    	}
			    // SI ID Etudiant
			    	else{
			    		int buffergroupe;
						 query=	"SELECT * FROM etudiant WHERE etudiant_ID =";
						 query+=Integer.toString(userid);
						 buffergroupe=0;
						 try {
							     result= conn.createStatement().executeQuery(query);
								  while(result.next())
								  {
									  buffergroupe=result.getInt("etudiant_Groupe");
								  }
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						 query="SELECT DISTINCT * FROM seance INNER JOIN seancegroupes ON seance_ID=seanceGroupes_GroupeID WHERE seance.seance_Semaine= ";
						 query+= Integer.toString(semaine);
						 query+= "    AND seanceGroupes_GroupeID=";
						 query+= Integer.toString(buffergroupe);
						 try {
						     result= conn.createStatement().executeQuery(query);
							  while(result.next())
							  {
								  seances.add(dao.getSeancebyID(result.getInt("seance_ID")));
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
		return seances;
		
	}
}
