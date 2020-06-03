import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EnseignantDisplay extends JPanel {
	private ArrayList<Enseignant> todisplay=null;
	private ArrayList<JButton> boutton = new ArrayList<JButton>();
	public EnseignantDisplay(ArrayList<Enseignant> gr)
	{
		int i=0;
		todisplay=gr;
		this.setLayout(new GridLayout(1,gr.size()));
		for(i=0;i<gr.size();i++)
		{
			boutton.add(new JButton(new String("gr"+gr.get(i).getnom())));
			
			boutton.get(i).setBorderPainted(false);
			boutton.get(i).setBackground(Color.GRAY);
			
			this.add(boutton.get(i));
		}
		this.setVisible(true);
		this.validate();
	}
}
