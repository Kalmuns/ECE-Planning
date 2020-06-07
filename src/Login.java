import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel{
// Va servir de page d'accueuil.
	// Sers a login un mec 
		JTextField username,mdp ;
		JLabel userJLabel,mdpJLabel;
		JButton login=new JButton("Login");
//		private user p = new user();
//		private retrieveMySQL sql = new retrieveMySQL();
	    private Wall wa;


	// p=sql.retrievePerson(user.getText());
	// p.getID()
	//if(p.getmdp()==pass.getText())
	//{
	//    //connexion...
	//}


	public Login(Wall a, int[] log) {
			wa = a;
			username = new  JTextField(20);
			mdp = new JPasswordField(20);
			userJLabel = new JLabel("Mail :  ");
			mdpJLabel = new JLabel("Login :  ");
			add(userJLabel);
			add(username);
			add(mdpJLabel);
			add(mdp);
			add(login);
			

			login.addActionListener(new LoginButton());
			
			


			this.setVisible(true);

		}
			
			// TODO Auto-generated constructor stub
			private class LoginButton implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					int id=0;
					DAO dao=new DAO();
					id=dao.login(username.getText(), mdp.getText());
					if(id!=0)
					{
					
					wa.setID(id);
					wa.rset();
					wa.act(1);
					}
				}
			}

}
