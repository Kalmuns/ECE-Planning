/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import guiv0.pkg1.Wall;
import java.awt.GridLayout;
//import java.awt.List;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Kalmuns
 */
public class CoursPanel extends JPanel
{
    //private Wall wall;
//    ArrayList<JLabel> info;
//    ArrayList<JButton> rdvlink;
    //private MeetingCase de;

    private int iD;
    List<JPanel> coursList = new ArrayList<JPanel>();
    List<JPanel> semaineList = new ArrayList<JPanel>();


    public CoursPanel()
    {
        System.out.println("page MeetingPanel");
        //iD=id;
        int i;
        //wall=wa;
//        info=new ArrayList<>();
//        rdvlink=new ArrayList<>();
        //this.getLayout().addLayoutComponent("as", info.get(0));
        setVisible(true);
        setEnabled(true);
        this.validate();
        System.out.println("Semaine Panel constructor");
        for(i=0;i<36;i++)
        {
            coursList.add(new CoursCase(60));// 60  doit être id du rendez vous
//            rdvlink.add(new JButton("Link"));
//            info.add(new JLabel(("Info doc")));
        }

        setLayout(new GridLayout(6,6 ,0,0));
        for(i=0;i<36;i++)
        {
            add(coursList.get(i));
//         add(info.get(i));
//         add(rdvlink.get(i));
        }
        //this.getLayout().addLayoutComponent("as", info.get(0));
        setVisible(true);
        setEnabled(true);
        this.validate();
        System.out.println("meeting panel constructor");
    }

}
