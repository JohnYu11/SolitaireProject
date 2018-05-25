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

public class GuiMethods extends JComponent 
{
    // instance variables
    private static final int CARD_WIDTH = 73;
	private static final int CARD_HEIGHT = 97;
	private static final int SPACING = 5;  //distance between cards
	private static final int FACE_UP_OFFSET = 15;  //distance for cascading face-up cards
	private static final int FACE_DOWN_OFFSET = 5;  //distance for cascading face-down cards

	private JFrame frame;
	private int selectedRow = -1;
	private int selectedCol = -1;
	private Game game;


    /**
     * Constructs a new instance of GuiMethods
     */
    public GuiMethods()
    {
        this.game = game;

		frame = new JFrame("Solitaire");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);

		this.setPreferredSize(new Dimension(CARD_WIDTH * 7 + SPACING * 8, CARD_HEIGHT * 2 + SPACING * 3 + FACE_DOWN_OFFSET * 7 + 13 * FACE_UP_OFFSET));


		frame.pack();
		frame.setVisible(true);
    }
    public void paint(Graphics g)
    {
       
    }
    public static void main(String[]args){
        GuiMethods application = new GuiMethods();
    }
    public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 0, 0));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
