import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel{
// Va servir de page d'accueuil.
	// Sers a login un mec 
		JTextField username,mdp ;
		JLabel userJLabel,mdpJLabel;
		JButton login=new JButton("Login");
		
	
	
		public Login() {
			username=new  JTextField(20);
			mdp=new JTextField(20);
			userJLabel= new JLabel("Username :  ");
			mdpJLabel=new JLabel("Login :  ");
			add(userJLabel);
			add(username);
			add(mdpJLabel);
			add(mdp);
			add(login);
			
			
			
			
			
			
			this.setVisible(true);
			
			// TODO Auto-generated constructor stub
		}
}
