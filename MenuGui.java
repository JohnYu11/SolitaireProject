/**
 * FINAL PROJECT
 * John Yu
 * 5/7/2018
 * Description: Creates the panel and other graphical objects of the
 *              User Interface that allows for the game to be played.
 * Purpose: Makes it possible for the player to play the game.
 */
import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import java.io.*;           //access to input/output
import javax.swing.*;       // access to JFrame and Jcomponents
import java.util.*;

public class MenuGui extends JComponent implements MouseListener
{
    // instance variables
    private JFrame frame;   //creates object for JFrame
    private Menu men;  //creates object for game class

    /**
     * Constructs a new instance of GuiMethods
     */
    public MenuGui(Menu men)
    {
        this.men = men;   //creates an instance of game that is this game
        frame = new JFrame("Solitaire");    //the name of the application at the top
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //allows the application to be closed
        frame.getContentPane().add(this);   //adds the game to the window

        this.setPreferredSize(new Dimension(930, 620)); //the size of the window is 930*620
        this.addMouseListener(this);    //adds a mouse listener

        frame.pack();   //makes the elements fit inside the window size
        frame.setVisible(true);     //allows the window to be visible
    }

    public void paint(Graphics g)
    {
       g.setColor(new Color(81, 2, 39));
       g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawButton(Graphics g, int x, int y)
    {
        
    }

    private void drawHome(Graphics g, int x, int y)
    {
        try
        {
            String fileName = ("homepage.gif");
            if (!new File(fileName).exists())
                throw new IllegalArgumentException("bad file name:  " + fileName);
            Image image = new ImageIcon(fileName).getImage();
            g.drawImage(image, x, y, getWidth(), getHeight(), null);
        }
        catch(IllegalArgumentException e)
        {
            new Game();
        }
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
       
    }

    public void unselect()
    {
       
    }
}
