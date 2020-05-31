/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import javax.swing.*;


/**
 *
 * @author Kalmuns
 */
public class CoursDisplay extends JPanel
{
    private WallCalendrier wallCalendrier;
    private int idCours;
    public CoursDisplay(int id)
    {
        System.out.println("page CoursCase");
        //wall=wa;
        idCours=id;
        this.setVisible(true);
        this.setLayout(new BorderLayout());
//        add(new CoursInfo(idCours),BorderLayout.CENTER);
        add(new CoursInfo(idCours));
        // ajouter condition d'affichage pour l'admin
        validate();
    }

}

