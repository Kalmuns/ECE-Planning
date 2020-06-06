import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GroupeDisplayer extends JPanel {
	private ArrayList<Groupe> todisplay=null;
	private ArrayList<JButton> boutton = new ArrayList<JButton>();
	private WallCalendrier wallCalendrier;
	int j;
	public GroupeDisplayer(ArrayList<Groupe> gr, WallCalendrier c)
	{
		int i=0;
		j=i;
		wallCalendrier=c;
		todisplay=gr;
		this.setLayout(new GridLayout(1,gr.size()));
		for(i=0;i<gr.size();i++)
		{
		
			boutton.add(new JButton(new String("gr"+gr.get(i).getnom())));
			
			boutton.get(i).setBorderPainted(false);
			boutton.get(i).setBackground(Color.GRAY);
			
			this.add(boutton.get(i));
			boutton.get(i).addActionListener(new NomBouton());
			
		}
		this.setVisible(true);
		this.validate();
	}
	private class NomBouton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Groupe groupe = todisplay.get(1);
			int group_Nom = groupe.getid();
			System.out.println(group_Nom);
			wallCalendrier.actualCalendrier(1, 0, 0);
			
		}
	}
}
