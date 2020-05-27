
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HeureDisplay extends JPanel
{
    private WallCalendrier wallCalendrier;
//    ArrayList<JLabel> info;
//    ArrayList<JButton> rdvlink;
    //private MeetingCase de;

    private int iD;
    List<JPanel> heuresList = new ArrayList<>();

    public HeureDisplay() {
        System.out.println("page heures panel");
        //iD = id;
        int i;
        //wall = wa;
//        info=new ArrayList<>();
//        rdvlink=new ArrayList<>();

        for(i=0;i<6;i++)
        {
            heuresList.add(new heuresJour(60));// 60  doit être id du rendez vous
//            rdvlink.add(new JButton("Link"));
//            info.add(new JLabel(("Info doc")));
        }

        setLayout(new GridLayout(6,1 ,0,0));
        for(i=0;i<6;i++)
        {
            add(heuresList.get(i));
//         add(info.get(i));
//         add(rdvlink.get(i));
        }
        //this.getLayout().addLayoutComponent("as", info.get(0));
        setVisible(true);
        setEnabled(true);
        this.validate();
        System.out.println("Heures Panel constructor");
    }
}
