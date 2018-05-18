
/**
 * FINAL PROJECT
 * Fiona Harrington
 * 5/7
 * 
 * Description: Creates the random piles of cards and declares and instantiates the piles and
 * runs the game class
 * Purpose: To prepare the cards to begin the game and run the program
 */
import java.util.*;
public class GameTester
{
    public static void solitaire(String[] args)
    {
        ArrayList<Card> deck = new ArrayList<Card>(); //creates the initial lists
        ArrayList<Card> d1 = new ArrayList<Card>();
        ArrayList<Card> d2 = new ArrayList<Card>();
        ArrayList<Card> d3 = new ArrayList<Card>();
        ArrayList<Card> d4 = new ArrayList<Card>();
        ArrayList<Card> d5 = new ArrayList<Card>();
        ArrayList<Card> d6 = new ArrayList<Card>();
        ArrayList<Card> d7 = new ArrayList<Card>();

        for(int x = 0; x < 13; x++) //add all 53 cards to the main deck
        {
            deck.add(new Card(x,"diamond",true));
        }
        for(int x = 0; x < 13; x++)
        {
            deck.add(new Card(x,"heart",true));
        }
        for(int x = 0; x < 13; x++)
        {
            deck.add(new Card(x,"club",false));
        }
        for(int x = 0; x < 13; x++)
        {
            deck.add(new Card(x,"spade",false));
        }

        Pile mainPile = new Pile(); //Creates the initial piles of cards
        Pile p1 = new Pile();
        Pile p2 = new Pile();
        Pile p3 = new Pile();
        Pile p4 = new Pile();
        Pile p5 = new Pile();
        Pile p6 = new Pile();
        Pile p7 = new Pile();

        int y = 51; //the number of cards left in the deck

        for(int x = 0; x < 7; x++) //add cards in descending lengths to the piles
        {
            Card temp = deck.get((int) (Math.random() * y));
            d1.add(temp);
            deck.remove(temp);
            y--;
        }
        for(int x = 0; x < 6; x++) //add cards in descending lengths to the piles
        {
            Card temp = deck.get((int) (Math.random() * y));
            d2.add(temp);
            deck.remove(temp);
            y--;
        }
        for(int x = 0; x < 5; x++) //add cards in descending lengths to the piles
        {
            Card temp = deck.get((int) (Math.random() * y));
            d3.add(temp);
            deck.remove(temp);
            y--;
        }
        for(int x = 0; x < 4; x++) //add cards in descending lengths to the piles
        {
            Card temp = deck.get((int) (Math.random() * y));
            d4.add(temp);
            deck.remove(temp);
            y--;
        }
        for(int x = 0; x < 3; x++) //add cards in descending lengths to the piles
        {
            Card temp = deck.get((int) (Math.random() * y));
            d5.add(temp);
            deck.remove(temp);
            y--;
        }
        for(int x = 0; x < 2; x++) //add cards in descending lengths to the piles
        {
            Card temp = deck.get((int) (Math.random() * y));
            d6.add(temp);
            deck.remove(temp);
            y--;
        }
        for(int x = 0; x < 1; x++) //add cards in descending lengths to the piles
        {
            Card temp = deck.get((int) (Math.random() * y));
            d7.add(temp);
            deck.remove(temp);
            y--;
        }

        mainPile.addCards(deck); //Create the final piles
        p1.addCards(d1);
        p2.addCards(d2);
        p3.addCards(d3);
        p4.addCards(d4);
        p5.addCards(d5);
        p6.addCards(d6);
        p7.addCards(d7);

        Game gme = new Game(mainPile,p1,p2,p3,p4,p5,p6,p7); //begin the game
    }
}
