import javax.swing.*;
import java.util.ArrayList;

public class InfoEtudiant extends JPanel
{
    private Wall wall;
    private ArrayList<Integer> utilisateur_ID;
    private ArrayList<JLabel> utilisateur_Email;
    private ArrayList<JLabel> utilisateur_Nom;
    private ArrayList<JLabel> utilisateur_Prenom;

//    private ArrayList<Doc> baba = new ArrayList<>(100);
//    private retrieveMySQL tutu = new retrieveMySQL();
    public InfoEtudiant(Wall wa, String search)
    {
        wall=wa;
        int i=0;
        utilisateur_ID=new ArrayList<>();
        utilisateur_Email=new ArrayList<>();
        utilisateur_Nom=new ArrayList<>();
        utilisateur_Prenom=new ArrayList<>();
    }
}
