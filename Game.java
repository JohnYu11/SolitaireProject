
/**
 * FINAL PROJECT
 * Fiona Harrington
 * 5/7/2018
 * Description: allows the user to move around cards on the board and
 * play the game under the given rules.
 * Purpose: to facilitate the playing of the game.
 */
public class Game
{
    public Pile deck, pile1, pile2, pile3, pile4, pile5, pile6, pile7;
    public Pile hearts,spades,clubs,diamonds;
    public int moves;
    public Game(Pile mainPile, Pile firstPile, Pile secondPile, Pile thirdPile, Pile fourthPile,
    Pile fifthPile, Pile sixthPile, Pile seventhPile)
    {
        deck = mainPile;  //pass in the eight base piles needed in the game
        pile1 = firstPile;
        pile2 = secondPile;
        pile3 = thirdPile;
        pile4 = fourthPile;
        pile5 = fifthPile;
        pile6 = sixthPile;
        pile7 = seventhPile;
        moves = 0; //begins to count the moves
    }
    /**checks if user has made a valid move*/
    public boolean canMove()
    {
        return true;
    }
    
    /**moves cards from on pile to another*/
    public void move()
    {
    }
    
    /**controls how the deck moves*/
    public void moveDeck()
    {
    }
    
    /**Check if the user has won*/
    public boolean hasWon()
    {
        return true;
    }
}
