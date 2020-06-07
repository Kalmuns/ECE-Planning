/**
 * Classe Cour
 * @author Kalmuns
 *
 */
public class TypeCour {
	private int id;
	private String nom;
	public TypeCour(int i, String no)
	{
		id=i;
		nom=no;
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
	public String getsitenom()
	{
		return nom;
	}
}
