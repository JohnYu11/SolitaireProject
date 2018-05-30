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
import apcslib.*;

public class GuiMethods extends JComponent implements MouseListener
{
    // instance variables
    private static final int cardwide = 70;
    private static final int cardhigh = 95;
    private static final int space = 30;  //distance between cards
    private static final int up_offset = 20;  //distance for cascading face-up cards
    private static final int down_offset = 10;  //distance for cascading face-down cards

    private JFrame frame;   //creates object for JFrame
    private int selectedRow = -1;
    private int selectedCol = -1;
    private Game game;  //creates object for game class

    /**
     * Constructs a new instance of GuiMethods
     */
    public GuiMethods(Game game)
    {
        this.game = game;

        frame = new JFrame("Solitaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);

        this.setPreferredSize(new Dimension(930, 620));
        this.addMouseListener(this);

        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(new Color(81, 2, 39));
        g.fillRect(cardwide+(space), 0, getWidth()-2*(space+cardwide), getHeight());
        g.setColor(new Color(209,184,191));
        g.fillRect(0, 0, cardwide+(space), getHeight());
        g.fillRect(cardwide+(space)+getWidth()-2*(space+cardwide), 0, cardwide+(space), getHeight());
        //hand
        drawCard(g, game.getHand(), space/2 , space);

        //talon
        drawCard(g, game.getTalon(), space/2, space+(cardhigh + 2 * space));
        if (selectedRow == 0 && selectedCol == 1)
            drawBorder(g, space/2, space+(cardhigh + 2 * space));

        //foundation
        for (int k = 0; k < 4; k++)
            drawCard(g, game.getFoundation(k), getWidth()-(space/2)-cardwide,space+(cardhigh + 2 * space)*k);

        //tableau
        for (int n = 0; n < 7; n++)
        {
            Stack<Card> pile = game.getTableau(n);
            int offset = 0;
            for (int j = 0; j < pile.size(); j++)
            {
                drawCard(g, pile.get(j),space+(cardwide+space)*(n+1), space + offset);
                if (selectedRow == 1 && selectedCol == n && j == pile.size() - 1)
                    drawBorder(g, space+(cardwide+space)*(n+1), space + offset);

                if (pile.get(j).isFaceUp())
                    offset += up_offset;
                else
                    offset += down_offset;
            }
        }
    }

    private void drawBorder(Graphics g, int x, int y)
    {
        g.setColor(Color.GRAY);
        g.drawRect(x, y, cardwide, cardhigh);
        g.drawRect(x + 1, y + 1, cardwide - 2, cardhigh - 2);
        g.drawRect(x + 2, y + 2, cardwide - 4, cardhigh - 4);
    }

    private void drawCard(Graphics g, Card card, int x, int y)
    {
        if (card == null)
        {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, cardwide, cardhigh);
        }
        else
        {
            String fileName = card.getFileName();
            if (!new File(fileName).exists())
                throw new IllegalArgumentException("bad file name:  " + fileName);
            Image image = new ImageIcon(fileName).getImage();
            g.drawImage(image, x, y, cardwide, cardhigh, null);
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
        repaint();
    }

    public void unselect()
	{
		selectedRow = -1;
		selectedCol = -1;
	}

	public boolean isTalonSelected()
	{
		return selectedRow == 0 && selectedCol == 1;
	}

	public void selectTalon()
	{
		selectedRow = 0;
		selectedCol = 1;
	}

	public boolean isTableauSelected()
	{
		return selectedRow == 1;
	}

	public int selectedTableau()
	{
		if (selectedRow == 1)
			return selectedCol;
		else
			return -1;
	}

	public void selectTableau(int index)
	{
		selectedRow = 1;
		selectedCol = index;
	}
}
