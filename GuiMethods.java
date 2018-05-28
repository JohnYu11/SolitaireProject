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

public class GuiMethods extends JComponent implements MouseListener
{
    // instance variables
    private static final int cardwide = 73;
    private static final int cardhigh = 97;
    private static final int space = 5;  //distance between cards
    private static final int up_offset = 15;  //distance for cascading face-up cards
    private static final int down_offset = 5;  //distance for cascading face-down cards

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

        this.setPreferredSize(new Dimension(cardwide * 7 + 
                space * 8, cardhigh * 2 + space * 3 
                + down_offset * 7 + 13 * up_offset));
        this.addMouseListener(this);

        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(new Color(0, 128, 0));
        g.fillRect(0, 0, getWidth(), getHeight());
        //face down
        drawCard(g, game.getHand(), space, space);

        //stock
        drawCard(g, game.getTalon(), space * 2 + cardwide, space);
        if (selectedRow == 0 && selectedCol == 1)
            drawBorder(g, space * 2 + cardwide, space);

        //aces
        for (int i = 0; i < 4; i++)
            drawCard(g, game.getFoundation(i), space * (4 + i) + cardwide * (3 + i), space);

        //piles
        for (int i = 0; i < 7; i++)
        {
            Stack<Card> pile = game.getTableau(i);
            int offset = 0;
            for (int j = 0; j < pile.size(); j++)
            {
                drawCard(g, pile.get(j), space + (cardwide + space) * i, cardhigh + 2 * space + offset);
                if (selectedRow == 1 && selectedCol == i && j == pile.size() - 1)
                    drawBorder(g, space + (cardwide + space) * i, cardhigh + 2 * space + offset);

                if (pile.get(j).isFaceUp())
                    offset += up_offset;
                else
                    offset += down_offset;
            }
        }
    }

    private void drawBorder(Graphics g, int x, int y)
    {
        g.setColor(Color.YELLOW);
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
        int col = e.getX() / (space + cardwide);
        int row = e.getY() / (space + cardhigh);
        if (row > 1)
            row = 1;
        if (col > 6)
            col = 6;

        if (row == 0 && col == 0)
            game.handPressed();
        else if (row == 0 && col == 1)
            game.talonPressed();
        else if (row == 0 && col >= 3)
            game.foundationPressed(col - 3);
        else if (row == 1)
            game.tableauPressed(col);
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

    public void selectTableau(int k)
    {
        selectedRow = 1;
        selectedCol = k;
    }
}
