import java.util.ArrayList;

public class Seance {
	// A discuter a 3
	ArrayList<Groupe> groupe = new ArrayList<Groupe>() ;
	Cour cour=null;
	TypeCour typeCour=null;
	ArrayList<Enseignant> enseignant= new ArrayList<Enseignant>();
	ArrayList<Salle> salle= new ArrayList<Salle>();
	int idseance,semaine,date,crenau,duree,etat,heure_debut;  /// Heure début /fin ? pas sur 
	
	
	
	public Seance(ArrayList<Groupe> groupes,ArrayList<Enseignant> enseignants,ArrayList<Salle> salles, int id, int dates, int hd, int duree, int etats, int semaine, Cour cour,TypeCour typeCour )
	{
		groupe=groupes;
		enseignant=enseignants;
		this.salle=salles;
	
		idseance=id;
		this.semaine=semaine;
		date=dates;
		etat=etats;
		heure_debut=hd;
		this.duree=duree;
		this.cour=cour;
		this.typeCour=typeCour;
	}
	public ArrayList<Groupe> getgroupes()
	{
		return groupe;
	}
//	public String getnomseance()
//	{
//		return nomseance;
//	}
	public Cour getCour()
	{
		return cour;
	}
	public TypeCour gettypeCour()
	{
		return typeCour;
	}
	public ArrayList<Enseignant> getEnseignants()
	{
		return enseignant;
	}
	public ArrayList<Salle> getsalle()
	{
		return salle;
	}
	public int getidseance()
	{
		return idseance;
	}
	public int getsemaine()
	{
		return semaine;
	}
	public int getdate()
	{
		return date;
	}
	public int getetat()
	{
		return etat;
	}
	public int getheure_debut()
	{
		return heure_debut;
	}
	public int getduree()
	{
		return duree;
	}
}
