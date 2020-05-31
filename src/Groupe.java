
public class Groupe {
	private int id,promotionid;
	private String nom;
	public Groupe(int i,int pro, String no) {
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
