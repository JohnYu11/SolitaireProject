
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
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class GuiMethods
     */
    public GuiMethods()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
