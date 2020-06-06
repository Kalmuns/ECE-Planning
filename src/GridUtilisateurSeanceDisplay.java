import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GridUtilisateurSeanceDisplay extends JPanel{
	
	ArrayList<Groupe> groupes=new ArrayList<Groupe>();
	ArrayList<Enseignant> enseignants =new ArrayList<Enseignant>();

	public GridUtilisateurSeanceDisplay(ArrayList<Enseignant> enseignants)
	{
		DAO dao=new DAO();
		groupes=dao.getGroupbyEnseignant(enseignants);
		if (enseignants!=null)
		{
			this.setLayout(new GridLayout(groupes.size(), 1));
			int i;
			for(i=0;i<groupes.size();i++)
			{
				//System.out.println("Griseance "+i+"  "+ this.getParent());
				this.add(new InfoUser(dao.getSeancebyGroupEnseignant(enseignants, groupes.get(i)),groupes.get(i).getnom(),enseignants));
			}
			
		}
		this.setVisible(true);
		this.validate();
	}
	
	
}
