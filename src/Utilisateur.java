/**
 * Classe Utilisateur 
 * @author Kalmuns
 *
 */
public class Utilisateur {

		String email,password,nom,prenom;
		int idUtilisateur,droit;
		public Utilisateur() {
			email=null;
			password=null;
			nom=null;
			prenom=null;
			
			// TODO Auto-generated constructor stub
		}
	
		
		public Utilisateur(int id, String em,String pa,String no,String pre,int dr) {
			idUtilisateur=id;
			email=em;
			password=pa;
			prenom=pre;
			nom=no;
			droit=dr;
		}
		
		public String getemail()
		{
			return email;
		}
		public String getpassword()
		{
			return password;
		}
		public String getnom()
		{
			return nom;
		}
		public String getprenom()
		{
			return prenom;
		}
		public int getdroit()
		{
			return droit;
		}
		public int getID()
		{
			return idUtilisateur;
		}
}