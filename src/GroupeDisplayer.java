import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GroupeDisplayer extends JPanel {
	private ArrayList<Groupe> todisplay=null;
	public GroupeDisplayer(ArrayList<Groupe> gr)
	{
		int i=0;
		todisplay=gr;
		this.setLayout(new GridLayout(1,gr.size()));
		for(i=0;i<gr.size();i++)
		{
			this.add(new JButton(new String("gr"+gr.get(i).getnom())));
		}
		this.setVisible(true);
		this.validate();
	}
}
