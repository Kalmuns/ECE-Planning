import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

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
//                 try {
//                    ResultSet result = conn.createStatement().executeQuery("SELECT * FROM etudiant");
//                      while(result.next())
//                      {
//                          System.out.println(result.getInt("etudiant_ID"));
//                      }
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }

                DAO dao=new DAO();
                Seance seance= dao.getSeancebyID(1);
              
                ArrayList<Enseignant> enseignants=new ArrayList<Enseignant>();
                enseignants=dao.getEnseignantsByName("pik");
                
                //System.out.println( " teststart "+ seance.getEnseignants().get(1).getnom());

                /* tes*/
            }

}