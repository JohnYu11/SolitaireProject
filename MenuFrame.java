
/**
 * Write a description of class MenuFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    private JLabel back;

    public MenuFrame()
    {
        menuFrame = new JFrame("Solitaire");
        back = new JLabel(new ImageIcon("Home Page I think the real one.gif"));
        start = new JLabel(new ImageIcon("LM277qNF (2).gif"));
        start.addMouseListener(this);
        back.setBounds(0, 0, 930, 620);

        menuFrame.setLayout( new FlowLayout() );
        menuFrame.add(back);
        menuFrame.add(start);
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.getContentPane().add(this);

        menuFrame.setSize(930,620);

        this.setPreferredSize(new Dimension(930, 620)); //the size of the window is 930*620

        menuFrame.setVisible(true);
    }

    public void mouseClicked(MouseEvent e)
    {
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
