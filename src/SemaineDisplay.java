
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Affiche les n de semaine et possede num semaine 
 * 
 * @author Kalmuns
 *
 */
public class SemaineDisplay extends JPanel
{
    private WallCalendrier wallCalendrier;
//    ArrayList<JLabel> info;
//    ArrayList<JButton> rdvlink;
    //private MeetingCase de;
    private int iD;
    List<JPanel> semaineList = new ArrayList<>();
    protected int cont;
    public SemaineDisplay(WallCalendrier c, int j,int contenu) {

        //iD = id;
    	cont = contenu;
        int i;
        //wall = wa;
//        info=new ArrayList<>();
//        rdvlink=new ArrayList<>();

        for(i=0;i<52;i++)
        {
            semaineList.add(new numSemaine(1, i, c,j,contenu));// 1  doit être id de la semaine
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
