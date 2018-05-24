/**
 * Write a description of class GuiMethods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and Jcomponents
import javax.swing.event.*;     // access to JSlider events

public class GuiMethods extends JFrame
{
    // instance variables
    private final static int numRow = 14;      //horizontal gap
    private final static int numCol = 9;      //vertical gap
    
    private JTextArea textArea1, textArea2;     //objects of JTextArea type
    private int xPos, yPos;     //position of mouse

    /**
     * Constructs a new game grid
     */
    public GuiMethods()
    {
        super();    //calls super
        Container contain = getContentPane();   //creates an object for a method
        contain.setLayout(new GridLayout(numRow, numCol));    //sets BorderLayout; gaps between components >= 0
        
        textArea1 = new JTextArea(2, 10);       //text area size 2 x 10
        textArea1.setText("Click the Mouse");   //tells player to press a button
        textArea1.setEnabled(false);    //makes it so that player can't type in text area
        textArea1.setBackground(Color.BLUE);    //sets background color as blue
        
        contain.add(textArea1);   //adds border components 
        contain.add(textArea2, GridLayout.SOUTH);   //adds border components
        
        addKeyListener(new KeyHandler());
        addMouseListener(new MouseClickHandler());
        
        addWindowListener(new java.awt.event.WindowAdapter()
            {
                public void windowClosing(WindowEvent evt){
                    System.exit(0);
                }
            }
        );
        
        setSize(500, 400);      //width= 500, height= 400
        setVisible(true);
    }
    /** METHOD EXPLINATION HERE **/
    public void paint(Graphics g)
    {
        super.paint(g);     //calls super method paint
        g.drawString("Clicked at [" + xPos + ", " + yPos + "]", xPos, yPos);
    }
    /** METHOD EXPLINATION HERE **/
    public static void main(String[]args)
    {
        GuiMethods application = new GuiMethods();
    }
}
