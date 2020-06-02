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
			userJLabel = new JLabel("Username :  ");
			mdpJLabel = new JLabel("Login :  ");
			add(userJLabel);
			add(username);
			add(mdpJLabel);
			add(mdp);
			add(login);
			String usertest = username.getText();
			String mdptest = mdp.getText();

			login.addActionListener(new LoginButton());
			
			


			this.setVisible(true);

		}
			
			// TODO Auto-generated constructor stub
			private class LoginButton implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					// p=sql.retrievePerson(user.getText());// q tester sur pc bdd;
					//  bufferlogin[0]=   p.getID();
					wa.rset();
					wa.act(1);
				}
			}

}
