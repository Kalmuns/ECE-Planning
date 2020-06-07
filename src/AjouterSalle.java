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
	private ArrayList<Salle> available= new ArrayList<Salle>();
	private Wall wall;
	
	
	public AjouterSalle(int idseanc, ArrayList<Salle> sal,Wall walls)
	{
		wall=walls;
		enseiBox=new JComboBox<String>();
		DAO dao=new DAO();
		salles=dao.getallsalle();
		available=sal;
		this.idseance=idseanc;
		for(int i=0;i<salles.size();i++)
		{
			enseiBox.addItem(salles.get(i).getnom());
		}
		this.setSize(100, 100);
		this.setLayout(new BorderLayout());
		add(enseiBox,BorderLayout.NORTH);
		valideButton.addActionListener(new ValidesalleListener());
		add(valideButton,BorderLayout.SOUTH);
		this.setLocation(300, 300);
		this.setTitle("AjouterSalle");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		this.validate();
	}
	
	private class ValidesalleListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int test=0;
			for(int i=0;i<available.size();i++)
			{
				if(salles.get(enseiBox.getSelectedIndex()).getid()==available.get(i).getid())
				{
					InsertBDD insertBDD=new InsertBDD();
					insertBDD.insertseancesalle(idseance, salles.get(enseiBox.getSelectedIndex()).getid());
					new Succes();
					dis();
					test=1;
					actualiser();
					
				}
			}
			if(test==0)
			{
				new Error();
			}
			dis();
		}
	}
	
	private void dis()
	{
		this.dispose();
	}
    private void actualiser()
    {
    	wall.actual(new WallSeancegrid(wall));
    }
}