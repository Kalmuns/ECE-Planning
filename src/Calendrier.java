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

public class Calendrier extends JPanel {
	
	// Display les information et contient le panel de cell
	
	
	public Calendrier(int semaine) {
		//this.setLayout(new GridLayout(7,7));
		DAO dao = new DAO();
		Insets inset = new Insets(2, 10, 2, 10);
		Outil test = new Outil();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		ArrayList<Seance> seances= new ArrayList<Seance>();
		seances =dao.getSeancesByWeek(1, semaine);
		System.out.println(seances.size() );
		this.setLayout(new GridBagLayout());
		gbc.gridy = 0;
		
		
		//JOUR DE LA SEMAINE
		//Lundi
		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.ipady = 10;
		gbc.ipadx = 30;
		
		JLabel lundi = new JLabel("Lundi");
		lundi.setBackground(Color.lightGray);
		//lundi.setOpaque(true);
		this.add(lundi, gbc);
		// Mardi
		gbc.gridx = 2;
		this.add(new JLabel("Mardi"), gbc);
		// Mercredi
		gbc.gridx = 3;
		this.add(new JLabel("Mercredi"), gbc);
		// Jeudi
		gbc.gridx = 4;
		this.add(new JLabel("Jeudi"), gbc);
		// Vendredi
		gbc.gridx = 5;
		this.add(new JLabel("Vendredi"), gbc);
		// Samedi
		gbc.gridx = 6;
		this.add(new JLabel("Samedi"), gbc);
		// Dimanche
		gbc.gridx = 7;
		this.add(new JLabel("Dimanche"), gbc);
				
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
		
		
		
		for(int i=0;i<7;i++)
		{
			for (int j = 0; j < 7; j++) {
				
			
			gbc.gridy = 1+i;
			gbc.gridx = 1+j;
			gbc.insets = inset;
			gbc.ipadx = 0;
			
			JPanel cell1 = new JPanel();
		    cell1.setBackground(Color.LIGHT_GRAY);
		    cell1.setPreferredSize(new Dimension(120, 70));
			this.add(cell1,gbc);
			}
		}
		for(int i=0;i<seances.size();i++)
		{
			
			
			gbc.insets = inset;
			gbc.gridy =seances.get(i).heure_debut;
			gbc.gridx =test.convertirJourInt(seances.get(i).getdate());
			this.add(new Cell(seances.get(0)),gbc);
			
		}
		gbc.gridx = 0;
		
		java.sql.Date dates = new java.sql.Date(2008,9,21);
		this.update(this.getGraphics());
		test.convertirJour(dates);
		System.out.println("Semaine: " +test.convertirJour(dates));
		this.setVisible(true);
		this.validate();
		
		
		// TODO Auto-generated constructor stub
	}
}
