
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SemaineDisplay extends JPanel
{
    private WallCalendrier wallCalendrier;
//    ArrayList<JLabel> info;
//    ArrayList<JButton> rdvlink;
    //private MeetingCase de;
    private int iD;
    List<JPanel> semaineList = new ArrayList<>();

    public SemaineDisplay(WallCalendrier c) {

        //iD = id;
        int i;
        //wall = wa;
//        info=new ArrayList<>();
//        rdvlink=new ArrayList<>();

        for(i=0;i<52;i++)
        {
            semaineList.add(new numSemaine(1, i, c));// 1  doit être id de la semaine
//            rdvlink.add(new JButton("Link"));
//            info.add(new JLabel(("Info doc")));
        }

        setLayout(new GridLayout(1,52 ,10,10));
        for(i=0;i<52;i++)
        {
            add(semaineList.get(i));
//         add(info.get(i));
//         add(rdvlink.get(i));
        }
        //this.getLayout().addLayoutComponent("as", info.get(0));
        
        setVisible(true);
        setEnabled(true);
        this.validate();
        
    }
}
