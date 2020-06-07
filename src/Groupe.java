/**
 * La classe Groupe Issue de la BDD
 * 
 *  
 *
 */

public class Groupe {
	private int id,promotionid;
	private String nom;
	public Groupe(int i, String no,int pro) {
		id=i;
		promotionid=pro;
		nom=no;
	}
	public int getid()
	{
		return id;
	}
	public int getpromotionid()
	{
		return promotionid;
	}
	public String getnom()
	{
		return nom;
	}
}
