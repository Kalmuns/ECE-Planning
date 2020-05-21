/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author Kalmuns
 */
public class CoursCase extends JPanel
{
    private Wall wall;
    private int idrdv;
    //private ArrayList<Doctor> doc  // utilisation des classes quand on mettra sql
    public CoursCase(int id)
    {
        System.out.println("page CoursCase");
        //wall=wa;
        idrdv=id;
        this.setVisible(true);
        this.setLayout(new BorderLayout());
//        add(new CoursInfo(idrdv),BorderLayout.CENTER);
        add(new CoursInfo(idrdv));
        // ajouter condition d'affichage pour l'admin
        validate();
    }

}

