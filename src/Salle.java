/**
 * class Salle
 * @author Kalmuns
 *
 */
public class Salle {
	int id,capacite,idsite;
	String nom;
	public Salle(int i ,String no , int cap ,int siteid) {
	id=i;
	capacite=cap;
	idsite=siteid;
	nom=no;
	}
	public int getid()
	{
		return id;
	}
	public String getnom()
	{
		return nom;
	}
	public int getcapacite()
	{
		return capacite;
	}
	public int getsiteid()
	{
		return idsite;
	}
}
