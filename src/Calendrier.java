import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Permet d'afficher les seances  
 * Est composé d'un GridBagLayout qui contient les différentes seances
 * Eest relié a Cell qui crée les seances
 *
 */

public class Calendrier extends JPanel {
	
	// Display les information et contient le panel de cell
	
	private Utilisateur user;
	protected WallCalendrier wallCalendrier;
	
	public Calendrier(int semaine, Utilisateur users, WallCalendrier c, int mode, int contenu) {
		//this.setLayout(new GridLayout(7,7));
		
		DAO dao = new DAO();
		
		wallCalendrier=c;
		Insets inset = new Insets(2, 10, 2, 10);
		Outil test = new Outil();
		int usersID=users.getID();
		//user=users;
		
		GridBagConstraints gbc = new GridBagConstraints();
		ArrayList<Seance> seances= new ArrayList<Seance>();
		int seancesAff[];
		//ArrayList<Salle> hopArrayList=test.salleDisponible(dao.getallsalle(), dao.getallseancebyweek(2));
		//System.out.println(hopArrayList.size());

		if (mode == 0) {
			seances =dao.getSeancesByWeek(usersID, semaine);
		}
		if (mode == 2) {
			seances =dao.getSeanceByCourWeek(contenu, semaine);
		}
		if (mode == 3) {
			
			seances =dao.getSeancesByWeek(contenu, semaine);
		}
		if (mode == 4) {
			
			seances =dao.getSeanceByGroupWeek(contenu, semaine);
		}
		if (mode == 5) {
			
			seances =dao.getSeancebySalleWeek(contenu, semaine);
			//System.out.println("Taille: "+seances.size());
		}
		this.setLayout(new GridBagLayout());
		gbc.gridy = 0;
		user= dao.getUtilisateurbyID(usersID);
		
		//JOUR DE LA SEMAINE
		//Lundi
		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.ipady = 10;
		gbc.ipadx = 30;
		
		
		String teString = new String();
				
		teString=test.GetDate(semaine, 2);
		JLabel lundi = new JLabel("Lundi "+teString);
		lundi.setBackground(Color.lightGray);
		//lundi.setOpaque(true);
		this.add(lundi, gbc);
		// Mardi
		gbc.gridx = 2;
		teString=test.GetDate(semaine, 3);
		this.add(new JLabel("Mardi "+teString), gbc);
		// Mercredi
		gbc.gridx = 3;
		teString=test.GetDate(semaine, 4);
		this.add(new JLabel("Mercredi "+teString), gbc);
		// Jeudi
		gbc.gridx = 4;
		teString=test.GetDate(semaine, 5);
		this.add(new JLabel("Jeudi "+teString), gbc);
		// Vendredi
		gbc.gridx = 5;
		teString=test.GetDate(semaine, 6);
		this.add(new JLabel("Vendredi "+teString), gbc);
		// Samedi
		gbc.gridx = 6;
		teString=test.GetDate(semaine, 7);
		this.add(new JLabel("Samedi "+teString), gbc);
		// Dimanche
		gbc.gridx = 7;
		teString=test.GetDate(semaine, 1);
		this.add(new JLabel("Dimanche "+teString), gbc);
				
		//Les Horaires
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("8h30 - 10h00"), gbc);
		// Mardi
		gbc.gridy = 2;
		this.add(new JLabel("10h15 - 11h45"), gbc);
		// Mercredi
		gbc.gridy = 3;
		this.add(new JLabel("12h00 - 13h30"), gbc);
		// Jeudi
		gbc.gridy = 4;
		this.add(new JLabel("13h45 - 15h15"), gbc);
		// Vendredi
		gbc.gridy = 5;
		this.add(new JLabel("15h30 - 17h00"), gbc);
		// Samedi
		gbc.gridy = 6;
		this.add(new JLabel("17h15 - 18h45"), gbc);
		// Dimanche
		gbc.gridy = 7;
		this.add(new JLabel("19h00 - 20h30"), gbc);
		
		
		
		
		
		
		for(int i=0;i<seances.size();i++)
		{
			
			
			gbc.insets = inset;
			gbc.gridy =seances.get(i).getheure_debut();
			gbc.gridx =test.convertirJourInt(seances.get(i).getdate());
			
			this.add(new Cell(seances.get(i),user,wallCalendrier,semaine),gbc);
			int heuresRestantes= seances.get(i).getduree();
            int j=1;
            while (heuresRestantes>1) {
                gbc.gridy =seances.get(i).getheure_debut()+j;
                gbc.gridx =test.convertirJourInt(seances.get(i).getdate());
                this.add(new Cell(seances.get(i),user,wallCalendrier,semaine),gbc);
                heuresRestantes--;
                j++;
            }
		}
		for(int i=0;i<7;i++)
		{
			for (int j = 0; j < 7; j++) {
				
					
					gbc.gridy = 1+i;
					gbc.gridx = 1+j;
					gbc.insets = inset;
					gbc.ipadx = 0;
					
					if (this.getWidth()==0) {
						JPanel cell1 = new JPanel();
					    cell1.setBackground(Color.LIGHT_GRAY);
					    cell1.setPreferredSize(new Dimension(120, 50));
						this.add(cell1,gbc);
					}
					
				
			
			
			}
		}
		gbc.gridx = 0;
		
		java.sql.Date dates = new java.sql.Date(2008,9,21);
		this.update(this.getGraphics());
		test.convertirJour(dates);
		
		this.setVisible(true);
		this.validate();
		
		
		// TODO Auto-generated constructor stub
	}
}
