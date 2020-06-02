import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class numSemaine extends JPanel
{

    protected JButton selectSemaine;
    protected int idSemaine;
    protected WallCalendrier wallCalendrier;

    public numSemaine(int idSemaine, int i)
    {
        selectSemaine =new JButton(i+1 +""  );
//        add(selectSemaine,BorderLayout.CENTER);
        add(selectSemaine);
        validate();

    }
    private class selectSemaine implements ActionListener
    {
        // A changer !!!!!!
        public void actionPerformed(ActionEvent e)
        {
        }
    }
}