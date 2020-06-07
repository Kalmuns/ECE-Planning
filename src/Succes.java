import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * JFrame purement decorative qui affiche Succes set sur dispose
 * @author Kalmuns
 *
 */


public class Succes extends JFrame{
	private JButton okButton;
	public Succes() {
	
		this.setLocation(300, 300);
		this.setAlwaysOnTop(true);
		this.setSize(200,200);
		this.setTitle("Succes");
		this.setLayout(new BorderLayout());
		okButton= new JButton("OK");
		okButton.addActionListener(new OkListener());
		this.add(new JLabel("SUCCES"),BorderLayout.NORTH);
		this.add(okButton,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.validate();
		// TODO Auto-generated constructor stub
	}
	private class OkListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dis();
		}
	}
	private void dis()
	{
		this.dispose();
	}
	
}
