import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class AjouterEnseignant extends JFrame{

	private JButton valideButton=new JButton("Valide");
	private int idseance;
	private JComboBox<String> enseiBox;
	private ArrayList<Enseignant> enseignants=new ArrayList<Enseignant>();
	
	public AjouterEnseignant(int idseanc)
	{
		enseiBox=new JComboBox<String>();
		DAO dao=new DAO();
		enseignants=dao.getallenEnseignants();
		this.idseance=idseanc;
		
		for(int i=0;i<enseignants.size();i++)
		{
			enseiBox.addItem(enseignants.get(i).getnom());
		}
		this.setSize(100, 100);
		this.setLayout(new BorderLayout());
		add(enseiBox,BorderLayout.NORTH);
		add(valideButton,BorderLayout.SOUTH);
		this.setLocation(300, 300);
		this.setTitle("AjouterEnseignant");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.validate();
	}
	
	private class ValideListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			InsertBDD insertBDD=new InsertBDD();
			insertBDD.insertseanceenseignant(idseance, enseignants.get(enseiBox.getSelectedIndex()).getID());
			dis();
		}
	}
	
	private void dis()
	{
		this.dispose();
	}
}
