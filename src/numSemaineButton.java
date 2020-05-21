
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.red;

public class numSemaineButton extends JPanel
{
    protected JButton selectSemaine;
    protected int idrdv;
    protected Wall wall;
    numSemaineButton(int id)
    {
        idrdv=id;
        //wall=wa;
        selectSemaine =new JButton("50");
        selectSemaine.setPreferredSize(new Dimension(50, 20));
        //suppmeeting.addActionListener(new MeetingCaseButton.SuppMeeting());
        //linktomeetingdetail.addActionListener(new MeetingCaseButton.Linkmeetingdetail());
        //this.setLayout(new BorderLayout());
        add(selectSemaine,BorderLayout.CENTER);
        //add(selectSemaine);

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
