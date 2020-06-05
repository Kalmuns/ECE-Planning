import javax.swing.*;
import java.awt.*;

public class WallSeance extends JPanel
{

    public WallSeance()
    {
        add(new RechercheSeanceDisplay(),BorderLayout.NORTH);
        add(new TableauSeanceDisplay(), BorderLayout.CENTER);
    }

}
