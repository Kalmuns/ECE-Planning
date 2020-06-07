import javax.swing.*;


import java.awt.GridLayout;
import java.util.ArrayList;
/**
 * affiche une row contenu dans grid utilisaeur
 * elle dysplay poour un groupe donnes les cours ( 1er dernier et duree) en fonction des professeur selectionne
 * les professeur en parametre sont ceux retourne par dao.getuserbyname
 * @author Kalmuns
 *
 */

/// ROW DU DISPLAY SEANCE NY ENSEIGNANT
public class InfoUser extends JPanel
{
   // private Wall wall;
    private ArrayList<Integer> utilisateur_ID;
    private ArrayList<JLabel> utilisateur_Email;
    private ArrayList<JLabel> utilisateur_Nom;
    private ArrayList<JLabel> utilisateur_Prenom;
    private String nomgr;

//    private ArrayList<Doc> baba = new ArrayList<>(100);
//    private retrieveMySQL tutu = new retrieveMySQL();
    public InfoUser(ArrayList<Seance> seances,String nomgroupe,ArrayList<Enseignant> enseignants)
    {
     //   wall=wa;
    	Outil outil=new Outil();
    	nomgr=nomgroupe;
    	if(seances.size()>0)
    	{
    		this.setLayout(new GridLayout(1,6));
    		String list= "Enseignant :";
    		for (Enseignant enseignant : enseignants) {
				list+= enseignant.getnom();
				list+="  ";
			}
    		this.add(new JLabel(list));
			this.add(new JLabel("Groupe : "+nomgr));
			this.add(new JLabel("Cour :  "+seances.get(0).getCour().getnom()));
			this.add(new JLabel("First seance : "+seances.get(0).getdate().toString()));
			this.add(new JLabel("Last Seance :"+seances.get(seances.size()-1).getdate().toString()));
			this.add(new JLabel("nb seance :"+outil.nbseance(seances)));
    	}
		this.setVisible(true);
		this.validate();
        //baba=tutu.rechercheDoc(search);
    }
}
