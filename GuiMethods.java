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
import javax.swing.event.*;     // access to JSlider events

public class GuiMethods extends JComponent 
{
    // instance variables
    private static final int cardwide = 73;
    private static final int cardhigh = 97;
    private static final int space = 5;  //distance between cards
    private static final int up_offset = 15;  //distance for cascading face-up cards
    private static final int down_offset = 5;  //distance for cascading face-down cards

    private JFrame frame;   //creates object for JFrame
    private int selectedRow = -1;
    private int selectedCol = -1;
    private Game game;  //creates object for game class

    /**
     * Constructs a new instance of GuiMethods
     */
    public GuiMethods()
    {
        this.game = game;

        frame = new JFrame("Solitaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);

        this.setPreferredSize(new Dimension(cardwide * 7 + 
        space * 8, cardhigh * 2 + space * 3 
        + down_offset * 7 + 13 * up_offset));

        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(new Color(100, 100, 100));
        g.fillRect(0, 0, getWidth(), getHeight());
        
      
    }

    public static void main(String[]args){
        GuiMethods application = new GuiMethods();
    }

}
