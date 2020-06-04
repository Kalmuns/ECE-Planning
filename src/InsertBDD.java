import java.sql.*;
import java.util.ArrayList;

public class InsertBDD {

	Connection conn=null;
	public InsertBDD()
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
	
	public void insertSeance(Date date,int heuredebut,int duree,int etat,int courid,int typecourid)
	{
		 Outil outil=new Outil();
		
		String semaineString=Integer.toString(outil.convertirSemaine(date));
		
		String query="INSERT INTO `seance` (`seance_ID`, `seance_Semaine`, `seance_Date`, `seance_HeureDebut`, `seance_HeureFin`, `seance_Etat`, `seance_CoursID`, `seance_TypeCoursID`) VALUES (";
			   query+= "NULL,";
			   query+= "'"+semaineString+"',";
			   query+= "'"+date.toString()+"',";
			   query+= "'"+Integer.toString(heuredebut)+"',";
			   query+="'"+Integer.toString(duree)+"',";
			   query+="'"+Integer.toString(etat)+"',";
			   query+="'"+Integer.toString(courid)+"',";
			   query+="'"+Integer.toString(typecourid)+"');";
			   try {
				     conn.createStatement().executeQuery(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
	}
	public void insertSeance(Date date,int heuredebut,int duree,int etat,int courid,int typecourid,ArrayList<Enseignant> enseignant, ArrayList<Groupe> groupe,ArrayList<Salle> salle)
	{
		 Outil outil=new Outil();
		
		String semaineString=Integer.toString(outil.convertirSemaine(date));
		
		String query="INSERT INTO `seance` (`seance_ID`, `seance_Semaine`, `seance_Date`, `seance_HeureDebut`, `seance_HeureFin`, `seance_Etat`, `seance_CoursID`, `seance_TypeCoursID`) VALUES (";
			   query+= "NULL,";
			   query+= "'"+semaineString+"',";
			   query+= "'"+date.toString()+"',";
			   query+= "'"+Integer.toString(heuredebut)+"',";
			   query+="'"+Integer.toString(duree)+"',";
			   query+="'"+Integer.toString(etat)+"',";
			   query+="'"+Integer.toString(courid)+"',";
			   query+="'"+Integer.toString(typecourid)+"');";
			   try {
				     conn.createStatement().executeQuery(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   query="SELECT * FROM seance ORDER BY seance_ID DESC LIMIT 1";
			   int idbuffer=-1;
				 try {
					    ResultSet result= conn.createStatement().executeQuery(query);
						  while(result.next())
						  {
							idbuffer=result.getInt("seance_ID");
						  }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  int i;
			  for(i=0;i<enseignant.size();i++)
			  {
				  insertseanceenseignant(idbuffer, enseignant.get(i).getID());
			  }
			  for(i=0;i<groupe.size();i++)
			  {
				  insertseancegroupes(idbuffer, groupe.get(i).getid());
			  }
			  for(i=0;i<salle.size();i++)
			  {
				  insertseancesalle(idbuffer, salle.get(i).getid());
			  }
	}
	
	public void insertseanceenseignant(int idseance, int idsenseignant)
	{
		String query="INSERT INTO `seanceenseignants` (`seanceEnseignants_SeanceID`, `seanceEnseignants_EnseignantsID`) VALUES ('"+idseance+"', '"+idsenseignant+"');" ;
		 try {
		     conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertseancegroupes(int idseance, int idgroupe)
	{
		String query="INSERT INTO `seancegroupes` (`seanceGroupes_SeanceID`, `seanceGroupes_GroupeID`) VALUES ('"+idseance+"', '"+idgroupe+"');" ;
		 try {
		     conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertseancesalle(int idseance, int idsalle)
	{
		String query="INSERT INTO `seancesalles` (`seanceSalles_SeanceIDID`, `seanceSalles_SalleID`) VALUES ('"+idseance+"', '"+idsalle+"');" ;
		 try {
		     conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
