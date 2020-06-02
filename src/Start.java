import java.sql.*;

public class Start {
	public static void main(String args[]) throws ClassNotFoundException
			{
		String url = "jdbc:mysql://localhost:3306/planning?autoReconnect=true&useSSL=false";

			Class.forName("com.mysql.jdbc.Driver");

		Connection conn=null;
		 try {
			 conn = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				new Fenetre();
//		         try {
//					ResultSet result = conn.createStatement().executeQuery("SELECT * FROM etudiant");
//					  while(result.next())
//					  {
//						  System.out.println(result.getInt("etudiant_ID"));
//					  }
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				DAO dao=new DAO();
				  System.out.println(dao.getUtilisateurbyID(1).getprenom());
				/* tes*/
			}
	
}
