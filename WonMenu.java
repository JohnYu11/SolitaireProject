
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
    public WonMenu(Game game) {
        this.game = game; // creates an instance of game that is this game
        frame = new JFrame("Solitaire"); // the name of the application at the top
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows the application to be closed
        frame.getContentPane().add(this); // adds the game to the window



        frame.setSize(930, 620);

        this.setPreferredSize(new Dimension(930, 620)); // the size of the window is 930*620

        frame.pack(); // makes the elements fit inside the window size
        frame.setVisible(true); // allows the window to be visible
    }

    public void paint(Graphics g) {
        Image image = new ImageIcon("src/CardImages/WonScreen.gif").getImage();
        g.drawImage(image, 0,0,930,620, null);
    }

}
