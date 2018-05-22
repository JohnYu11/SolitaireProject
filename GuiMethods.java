
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
        contain.setLayout(new BorderLayout(HGap, VGap));
        textArea1 = new JTextArea(2, 10);
        textArea1.setText("Click the Mouse");
        textArea1.setBackground(Color.BLUE);
    }

    
}
