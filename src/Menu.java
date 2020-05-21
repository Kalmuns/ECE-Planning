import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel  {
    
	// navigation tu peux reprendre celui que j'avais fait dans l'ancien projet niveau structure

	private JButton accueil;
	private JButton etd;
	protected Wall wall;
	public Menu(Wall wa)
	{
		accueil=new JButton ("Accueil");
		etd=new JButton ("ETD");
		accueil.addActionListener(new AccueilListener());
		etd.addActionListener(new edtListener());
		add(accueil);
		add (etd);
		wall= wa  ;
		setVisible(false);
		setEnabled(false);
		this.validate();
	
		
		// TODO Auto-generated constructor stub
	}
	private class AccueilListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// wall.
		}

	}
	private class edtListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			wall.add(new SemainePanel(), BorderLayout.NORTH);
			wall.add(new CoursPanel(),BorderLayout.CENTER);
			wall.add(new HeuresPanel(),BorderLayout.WEST);
		}

	}

}
