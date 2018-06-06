/**
 * Description: This is the gui class that builds the menu for entering the game
 *              and starting new games.
 *
 * @author Fiona and John
 * @created June 6th, 2018
 */
import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import java.io.*;           //access to input/output
import javax.swing.*;       // access to JFrame and Jcomponents
import java.util.*;

public class MenuFrame extends JComponent implements MouseListener
{
    private JFrame menuFrame;
    private JLabel start;

    public MenuFrame()
    {
        menuFrame = new JFrame("Solitaire");
        start = new JLabel(new ImageIcon("src/CardImages/home.gif"));
        start.addMouseListener(this);

        menuFrame.setLayout( new FlowLayout() );
        menuFrame.add(start);
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.getContentPane().add(this);

        menuFrame.setSize(930,620);

        this.setPreferredSize(new Dimension(930, 620)); //the size of the window is 930*620

        menuFrame.setVisible(true);
    }

    public void mouseClicked(MouseEvent e)
    {
        menuFrame.dispatchEvent(new WindowEvent(menuFrame, WindowEvent.WINDOW_CLOSING));
        Game g = new Game();
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
}
