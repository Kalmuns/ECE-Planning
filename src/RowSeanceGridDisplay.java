import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 *  Affiche les informations d'une seance dans grid display
 */
public class RowSeanceGridDisplay extends JPanel {
	
	private Wall wall;
	private JButton button;
	public RowSeanceGridDisplay(Seance seance,Wall walls)
	{
		this.setLayout(new GridLayout(1,9));
		wall=walls;
		this.add(new JLabel(" Date : "+seance.getdate().toString()));
		this.add(new JLabel("Heure :  "+seance.getheure_debut()));
		this.add(new JLabel("Duree : "+seance.getduree()));
		this.add(new JLabel("Etat :"+seance.getetat()));
		this.add(new JLabel("Court :"+seance.getCour().getnom()));
		this.add(new JLabel("TypeCourt :"+seance.gettypeCour().getsitenom()));
		int i=0;
		String actualString="Enseignant : ";
		for(i=0;i<seance.getEnseignants().size();i++)
		{
			actualString+=seance.getEnseignants().get(i).getnom();
			actualString+= " ";
		}
		this.add(new JLabel(actualString));
		actualString="Gr : ";
		for(i=0;i<seance.getgroupes().size();i++)
		{
			actualString+=seance.getgroupes().get(i).getnom();
			actualString+= " ";
		}
		this.add(new JLabel(actualString));
		button=new JButton("modifier");
		button.setName(Integer.toString(seance.getidseance()));
		button.addActionListener(new ModifierSeanceButton());
		this.add(button);
		
		this.setVisible(true);
		this.validate();
	}
	
	private class ModifierSeanceButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 wall.actual( new ModifSeanceDisplay(button.getName(),wall));
		}
	}

}
