/**
 * class site
 * @author Kalmuns
 *
 */
public class Site {
	private int id;
	private String nom;
	public Site(int i, String no)
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
