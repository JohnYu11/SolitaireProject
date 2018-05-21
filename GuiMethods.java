
/**
 * Write a description of class GuiMethods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and Jcomponents
import javax.swing.event.*;		// access to JSlider events

public class GuiMethods extends JFrame
{
    // instance variables
    private final static int HGap = 5;
    private final static int VGap = 5;
    private JTextArea textArea1, textArea2;
    private int xPos, yPos;

    /**
     * Constructor for objects of class GuiMethods
     */
    public GuiMethods()
    {
        super();
        Container contain = getContentPane();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        
    }
}
