/**
 * Correspond a la promotion comme la BDD
 * 
 *  
 *
 */


public class Promotion {
	private int id;
	private String nom;
	public Promotion(int i,String nom)
	{
		id=i;
		this.nom=nom;
	}
	public int getid()
	{
		return id;
	}
	public String getnom()
	{
		return nom;
	}
	
}
