import java.awt.GridLayout;
import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GridUtilisateurSeanceDisplay extends JPanel{
	
	ArrayList<Groupe> groupes=new ArrayList<Groupe>();
	ArrayList<Enseignant> enseignants =new ArrayList<Enseignant>();

	public GridUtilisateurSeanceDisplay(ArrayList<Enseignant> enseignants)
	{
		DAO dao=new DAO();
		groupes=dao.getGroupbyEnseignant(enseignants);
		System.out.println(" enseignants"+enseignants.size()+" groupes"+groupes.size());
		if (enseignants!=null&&groupes!=null)
		{
			this.setLayout(new GridLayout(groupes.size(), 1));
			int i;
			for(i=0;i<groupes.size();i++)
			{
				//System.out.println("Griseance "+i+"  "+ this.getParent());
				ArrayList<Seance> seance= new ArrayList<Seance>();
				seance=dao.getSeancebyGroupEnseignant(enseignants, groupes.get(i));
				System.out.println("size grid seance"+seance.size());
				this.add(new InfoUser(dao.getSeancebyGroupEnseignant(enseignants, groupes.get(i)),groupes.get(i).getnom(),enseignants));
			}
		}
		this.setVisible(true);
		this.validate();
	}
}
