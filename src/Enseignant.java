/**
 * Classe Enseignant issue de la BDD
 * 
 *    
 *
 */
public class Enseignant extends Utilisateur{
	

	private int courid;
	public Enseignant(int id, String em,String pa,String no,String pre,int dr, int courid)
	{
		super(id, em, pa, no, pre, dr);
		this.courid=courid;
	}

	public void setcourid(int no)
	{
		courid=no;
	}
	public int getgetcourid()
	{
		return courid;
	}
}
