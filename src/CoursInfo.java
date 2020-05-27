/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author Kalmuns
 */
public class CoursInfo extends JPanel
{
    private JLabel cours;
    private JLabel groupe;
    private JLabel salle;
    private int idrdv;//
    CoursInfo(int iD)
    {
        //  this.setLayout(new BorderLayout());
        idrdv=iD;
        cours = new JLabel("cours" + "\n");// recup info via idrdv
        groupe = new JLabel("groupe");
        salle = new JLabel("salle");
        add(cours);
        add(groupe);
        add(salle);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //add(doc,BorderLayout.WEST);
        //add(lieux,BorderLayout.CENTER);
        //add(date,BorderLayout.EAST);
        this.setVisible(true);
        this.validate();
    }
}
