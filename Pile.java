
/**
 * FINAL PROJECT
 * Fiona Harrington
 * Date: 5/4
 * Description: Pile can add cards to itself, remove cards, 
 * return cards, and has a type.
 * Purpose: To store objects that represent piles of cards and 
 * provide methods to edit those piles.
 */
import java.util.*;
public class Pile
{
    public ArrayList<Card> cardPile; //declares an arraylist to use as a method of describing each pile

    public Pile()
    {
        cardPile = new ArrayList<Card>(); //instantiates the declaration of the pile arraylist
    }

    /** adds the given array of cards to the pile*/
    public ArrayList<Card> addCards(ArrayList<Card> nextCards)
    {
        cardPile.addAll(nextCards); //adds the cards to the pile
        return nextCards; //returns the pile
    }

    /** removes given cards from the pile*/
    public void removeCards(ArrayList<Card> takeCards)
    {
        cardPile.removeAll(takeCards);
    }

    /** gets a card in a given position in a pile*/
    public Card getCard(int pos)
    {
        return cardPile.get(pos);
    }

    /**gets the last card in the pile*/
    public Card getLastCard()
    {
        return cardPile.get(cardPile.size());
    }
}
