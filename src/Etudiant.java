
public class Etudiant {

	private int etudiant_ID,numero,etudiant_Groupe_ID;
	public Etudiant(int eid, int num, int etu) {
		etudiant_ID=eid;
		numero=num;
		etudiant_Groupe_ID=etu;
	}
	public int getID()
	{
		return etudiant_ID;
	}
	public int getnumero()
	{
		return numero;
	}
	public int getgroupeID()
	{
		return etudiant_Groupe_ID;
	}
}
