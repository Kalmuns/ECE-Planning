/**
 * Classe Etudiant issue de la BDD
 * 
 *  
 *
 */
public class Etudiant extends Utilisateur {

	private int numero_etudiant,etudiant_Groupe_ID;
	public Etudiant(int id, String em,String pa,String no,String pre,int dr, int num, int etu) {
		super(id, em, pa, no, pre, dr);
		numero_etudiant=num;
		etudiant_Groupe_ID=etu;
	}

	public int getnumero_etudiant()
	{
		return numero_etudiant;
	}
	public int getgroupeID()
	{
		return etudiant_Groupe_ID;
	}
}
