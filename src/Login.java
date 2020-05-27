import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel{
// Va servir de page d'accueuil.
	// Sers a login un mec 
		JTextField username,mdp ;
		JLabel userJLabel,mdpJLabel;
		JButton login=new JButton("Login");
	    private WallCalendrier wa;



	public Login(WallCalendrier a, int[] log) {
			wa=a;
			username=new  JTextField(20);
			mdp=new JTextField(20);
			userJLabel= new JLabel("Username :  ");
			mdpJLabel=new JLabel("Login :  ");
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
//					wa.rset();
//					wa.act(1);
				}
			}

}
