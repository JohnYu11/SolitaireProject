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
import java.util.*;

public class SolitaireGui extends JComponent implements MouseListener
{
    // instance variables
    private static final int cardwide = 70; //card width
    private static final int cardhigh = 95; //card height
    private static final int space = 30;  //distance between cards
    private static final int up_offset = 20;  //distance for cascading face-up cards
    private static final int down_offset = 10;  //distance for cascading face-down cards

    private JFrame frame;   //creates object for JFrame
    private int selectedRow = -1;   //default row selected is none
    private int selectedCol = -1;   //default col selected is none
    private Game game;  //creates object for game class

    /**
     * Constructs a new instance of GuiMethods
     */
    public SolitaireGui(Game game)
    {
        this.game = game;   //creates an instance of game that is this game
        frame = new JFrame("Solitaire");    //the name of the application at the top
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //allows the application to be closed
        frame.getContentPane().add(this);   //adds the game to the window

        this.setPreferredSize(new Dimension(930, 620)); //the size of the window is 930*620
        this.addMouseListener(this);    //adds a mouse listener

        frame.pack();   //makes the elements fit inside the window size
        frame.setVisible(true);     //allows the window to be visible
    }

    public void paint(Graphics g)
    {
        g.setColor(new Color(81, 2, 39));
        //sets color to purpleish color
        g.fillRect(cardwide+(space), 0, getWidth()-2*(space+cardwide), getHeight());
        //fills middle area of screen with that color
        g.setColor(new Color(209,184,191));
        //sets color to lighter shade of pink
        g.fillRect(0, 0, cardwide+(space), getHeight());
        //fills the side areas with new color
        g.fillRect(cardwide+(space)+getWidth()-2*(space+cardwide), 0, cardwide+(space), getHeight());
        //fills side areas with new color
        
        //draws hand pile
        drawCard(g, game.getHand(), space/2 , space);

        //draws talon pile
        drawCard(g, game.getTalon(), space/2, space+(cardhigh + 2 * space));
        if (selectedRow == 0 && selectedCol == 1)
            drawBorder(g, space/2, space+(cardhigh + 2 * space));

        //draws foundation piles
        for (int k = 0; k < 4; k++)
            drawCard(g, game.getFoundation(k), getWidth()-(space/2)-cardwide,space+(cardhigh + 2 * space)*k);

        //draws tableau piles
        for (int n = 0; n < 7; n++)
        {
            Stack<Card> pile = game.getTableau(n);
            //creates stack of tableau pile
            int offset = 0;
            //the distance between cards
            for (int j = 0; j < pile.size(); j++)
            {
                drawCard(g, pile.get(j),space+(cardwide+space)*(n+1), space + offset);
                if (selectedRow == 1 && selectedCol == n && j == pile.size() - 1)
                    drawBorder(g, space+(cardwide+space)*(n+1), space + offset);
                //if pile selected then a border is drawn around it
                if (pile.get(j).isFaceUp())
                    offset += up_offset;
                    //increments offset
                else
                    offset += down_offset;
                    //increments offset
            }
        }
    }

    private void drawBorder(Graphics g, int x, int y)
    {
        g.setColor(Color.GRAY);     //sets color of border to gray
        
        //fills rectangle around card
        g.drawRect(x, y, cardwide, cardhigh);   
        g.drawRect(x + 1, y + 1, cardwide - 2, cardhigh - 2);
        g.drawRect(x + 2, y + 2, cardwide - 4, cardhigh - 4);
    }

    private void drawCard(Graphics g, Card card, int x, int y)
    {
        if (card == null)
        {
            g.setColor(Color.BLACK);    //sets color as black
            g.drawRect(x, y, cardwide, cardhigh);   //fills rectangle of card size
        }
        else
        {
            String fileName = card.getFileName();   //gets file name
            if (!new File(fileName).exists())
                throw new IllegalArgumentException("bad file name:  " + fileName);
            //throws an exception file inaccessible
            Image image = new ImageIcon(fileName).getImage();
            //gets the image
            g.drawImage(image, x, y, cardwide, cardhigh, null);
            //draws the image
        }
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

    public void mouseClicked(MouseEvent e)
    {
        //none selected previously
        double xPos = e.getX();
        double yPos = e.getY();
        int col = 0;
        int row = 0;
        //finds the column for tableau
        if((xPos>=130)&&(xPos<=200))
            col = 0;
        if((xPos>=230)&&(xPos<=300))
            col = 1;
        if((xPos>=330)&&(xPos<=400))
            col = 2;
        if((xPos>=430)&&(xPos<=500))
            col = 3;
        if((xPos>=530)&&(xPos<=600))
            col = 4;
        if((xPos>=630)&&(xPos<=700))
            col = 5;
        if((xPos>=730)&&(xPos<=800))
            col = 6;
        //find the row for foundation
        if((yPos>=30)&&(yPos<=125))
            row = 0;
        if((yPos>=185)&&(yPos<=280))
            row = 1;
        if((yPos>=340)&&(yPos<=435))
            row = 2;
        if((yPos>=495)&&(yPos<=590))
            row = 3;
        if ((xPos>=15)&&(xPos<=85)&&(yPos>=30)&&(yPos<=125))
        {
            game.handPressed();
        }
        else if ((xPos>=15)&&(xPos<=85)&&(yPos<=250)&&(yPos>=155))
        {
            game.talonPressed();
        }
        else if ((xPos>=845)&&(xPos<=915))
        {
            game.foundationPressed(row);
        }
        else if ((xPos>=130)&&(xPos<=800))
        {
            game.tableauPressed(col);
        }
        repaint();  //updates what is seen
    }

    public void unselect()
    {
        //deselects the pile selected by making selected pile null
        selectedRow = -1;      
        selectedCol = -1;
    }

    public boolean isTalonSelected()
    {
        return selectedRow == 0 && selectedCol == 1;
        //returns whether talon is selected
    }

    public void selectTalon()
    {
        //selects the talon
        selectedRow = 0;
        selectedCol = 1;
    }

    public boolean isTableauSelected()
    {
        return selectedRow == 1;
        //returns whether the tableau has been selected
    }

    public int selectedTableau()
    {
        if (selectedRow == 1)
            return selectedCol; //returns which tableau is selected
        else
            return -1;  //null pile selected otherwise
    }

    public void selectTableau(int index)
    {
        selectedRow = 1;    //returns the row selected
        selectedCol = index;    //returns the col selected
    }
}
