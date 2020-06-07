import javax.swing.*;
import java.awt.*;

public class Wall extends JPanel
{
    private int[] idpersonne;
    private int IDutilisateur;
    public Wall() {


        this.setLayout(new BorderLayout());
        // Appeler la page Login
        JPanel buffer= new Login(this,idpersonne);
        add(buffer,BorderLayout.CENTER);
        


        this.validate();
        setVisible(true);
    }
    public void rset()
    {
        int i;
        for (i=0;i<this.getComponentCount();i++)
        {
            getComponent(i).setVisible(false);
            getComponent(i).setEnabled(false);
        }
    }
    public void addMenu()
    {
    	JPanel buffer;
    	buffer=new Menu(this);
        add(buffer,BorderLayout.NORTH);
    }
    
    public void act(int i)
    {
        this.getComponent(i).setVisible(true);
        this.getComponent(i).setEnabled(true);
    }

    public void setmenu()
    {
        rset();
        act(1);
    }

    public void actual(JPanel s)
    {
        setmenu();
        this.remove(0);
//        System.out.println("add ok");

        add(s,BorderLayout.CENTER, 0);
        //System.out.println(this.getComponentCount()+" count in actual");
        act(0);

        this.revalidate();
    }
    public void setID(int id) {
    	IDutilisateur=id;
	}
    public int getID() {
		return IDutilisateur;
	}
    public void jFree() {
    	
	}
}
