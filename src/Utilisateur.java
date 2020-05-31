
public class Utilisateur {

		String email,password,nom,prenom,droit;
		int idUtilisateur;
		public Utilisateur() {
			email=null;
			password=null;
			nom=null;
			prenom=null;
			droit=null;
			
			// TODO Auto-generated constructor stub
		}
	
		
		public Utilisateur(int id, String em,String pa,String no,String pre,String dr) {
			idUtilisateur=id;
			email=em;
			password=pa;
			prenom=pre;
			nom=no;
			droit=dr;
		}
		
		
	
}