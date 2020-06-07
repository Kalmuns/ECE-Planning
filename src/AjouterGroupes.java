import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;



public class AjouterGroupes extends JFrame{

	private JButton valideButton=new JButton("Valide");
	private int idseance;
	private JComboBox<String> enseiBox;
	private ArrayList<Groupe> groupes=new ArrayList<Groupe>();
	private ArrayList<Groupe> available =new ArrayList<Groupe>();
	
	public AjouterGroupes(int idseanc, ArrayList<Groupe> gr)
	{
		enseiBox=new JComboBox<String>();
		DAO dao=new DAO();
		groupes=dao.getallgroupe();
		this.idseance=idseanc;
		available=gr;
		for(int i=0;i<groupes.size();i++)
		{
			enseiBox.addItem(groupes.get(i).getnom());
		}
		this.setSize(100, 100);
		this.setLayout(new BorderLayout());
		add(enseiBox,BorderLayout.NORTH);
		valideButton.addActionListener(new ValidegrListener());
		add(valideButton,BorderLayout.SOUTH);
		this.setLocation(300, 300);
		this.setTitle("AjouterGroupe");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.validate();
	}
	
	private class ValidegrListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int test=0;
			for(int i=0;i<available.size();i++)
			{
				if(groupes.get(enseiBox.getSelectedIndex()).getid()==available.get(i).getid())
				{
					test=1;
					new Error();
					dis();
				}
			}
			if(test==0)
			{
				InsertBDD insertBDD=new InsertBDD();
				insertBDD.insertseancegroupes(idseance, groupes.get(enseiBox.getSelectedIndex()).getid());
				dis();
				new Succes();
			}
			
		}
	}
	
	private void dis()
	{
		this.dispose();
	}
}