import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RechercheUser extends JPanel
{

    private JTextField searchfield;
    private JButton search;
    private Wall wall;
    public RechercheUser(Wall wa)
    {

        wall=wa;
        searchfield= new JTextField(30);
        this.setLayout(new BorderLayout());
        add(searchfield,BorderLayout.NORTH);
        search = new JButton("Search");
        search.addActionListener(new Search());
        //add(search,BorderLayout.EAST);
        add(new InitSearchField(searchfield,search),BorderLayout.NORTH);

        this.validate();
        setVisible(true);

    }
    private class Search implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            add(new InfoUser(wall,searchfield.getText()),BorderLayout.CENTER);
            revalidate();
        }

    }
    private class InitSearchField extends JPanel
    {
        private JTextField searchfield;
        private JButton search;
        InitSearchField(JTextField bufferfield, JButton bufferbutton)
        {
            search=bufferbutton;
            searchfield=bufferfield;
            add(searchfield);
            add(search);
        }
    }

}
