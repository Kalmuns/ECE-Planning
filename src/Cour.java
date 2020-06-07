/**
 * Classe Cours issue de la BDD
 * 
 *  
 *
 */
public class Cour {
	private int id;
	private String nom;
	public Cour(int id, String nom)
	{
		this.id=id;
		this.nom=nom;
	}
	public void setID(int i)
	{
		id=i;
	}
	public void setnom(String no)
	{
		nom=no;
	}
	public int getID()
	{
		return id;
	}
	public String getnom()
	{
		return nom;
	}
}
