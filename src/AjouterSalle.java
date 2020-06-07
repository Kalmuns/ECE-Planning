import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class AjouterSalle extends JFrame{

	private JButton valideButton=new JButton("Valide");
	private int idseance;
	private JComboBox<String> enseiBox;
	private ArrayList<Salle> salles=new ArrayList<Salle>();
	
	public AjouterSalle(int idseanc)
	{
		enseiBox=new JComboBox<String>();
		DAO dao=new DAO();
		salles=dao.getallsalle();
		this.idseance=idseanc;
		
		for(int i=0;i<salles.size();i++)
		{
			enseiBox.addItem(salles.get(i).getnom());
		}
		this.setSize(100, 100);
		this.setLayout(new BorderLayout());
		add(enseiBox,BorderLayout.NORTH);
		add(valideButton,BorderLayout.SOUTH);
		this.setLocation(300, 300);
		this.setTitle("AjouterSalle");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.validate();
	}
	
	private class ValideListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			InsertBDD insertBDD=new InsertBDD();
			insertBDD.insertseancesalle(idseance, salles.get(enseiBox.getSelectedIndex()).getid());
			dis();
		}
	}
	
	private void dis()
	{
		this.dispose();
	}
}