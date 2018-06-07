
/**
 * FINAL PROJECT
 * John Yu
 * 5/7/2018
 * Description: Creates the panel and other graphical objects of the
 *              User Interface that allows for the game to be played.
 * Purpose: Makes it possible for the player to play the game.
 */
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import java.io.*; //access to input/output
import javax.swing.*; // access to JFrame and Jcomponents

public class WonMenu extends JComponent{

    private JFrame frame; // creates object for JFrame
    private Game game; // creates object for game class
    /**
     * Constructs a new instance of WonMenu
     */

    private JFrame menuFrame;
    private JLabel start;

    public WonMenu()
    {
        menuFrame = new JFrame("Solitaire");
        start = new JLabel(new ImageIcon("src/CardImages/WonScreen.GIF"));

        menuFrame.setLayout( new FlowLayout() );
        menuFrame.add(start);
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.getContentPane().add(this);

        menuFrame.setSize(930,620);

        this.setPreferredSize(new Dimension(930, 620)); //the size of the window is 930*620

        menuFrame.setVisible(true);

    }

}
