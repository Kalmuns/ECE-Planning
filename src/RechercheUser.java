import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 *  Sert d'interface pour recuperer la srring de recherche pour le nom des professeur
 *  
 */
public class RechercheUser extends JPanel
{

    private JTextField searchfield;
    private JButton search;
    private WallUtilisateur wall;
    public RechercheUser(WallUtilisateur wa)
    {

        wall=wa;
        searchfield= new JTextField(30);
        search = new JButton("Search");
        search.addActionListener(new Search());
        //add(search,BorderLayout.EAST);
        add(searchfield);
        add(search);
        this.validate();
        setVisible(true);

    }
    /**
     * appel dao.get senseignent by name et renvoie le resultat dans wall displaygrid
     * @author Kalmuns
     *
     */
    private class Search implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	DAO dao= new DAO();
//            add(new InfoUser(wall,searchfield.getText()),BorderLayout.CENTER);
//            revalidate();
        	wall.displaygrid(dao.getEnseignantsByName(searchfield.getText()));
        }
    }


}
