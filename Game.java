/**
 * FINAL PROJECT
 * Fiona Harrington and John Yu
 * 5/7/2018
 * Description: allows the user to move around cards on the board and
 * play the game under the given rules.
 * Purpose: to facilitate the playing of the game.
 */
import java.util.*;
public class Game
{
    private Stack<Card>[]foundation;
    //the array for the stacks for the 4 suit piles
    private Stack<Card>[] tableau;
    //the array for the stacks for the 7 random piles
    private Stack<Card> hand;
    //the stack for the free cards
    private Stack<Card> talon;
    //the stack for the unused free cards
    private GuiMethods gui;
    //creates an object for GuiMethods class
    public int moves;
    //the # of moves taken so far
    /**
     * Game Constructor
     *
     */
    public Game()
    {
        foundation = new Stack[4];
        //creates foundation stack of size 4
        for(int k = 0; k < foundation.length; k++){
            foundation[k] = new Stack();
            //sets each array space as a new stack
        }
        tableau = new Stack[7];
        //creates tableau stack of size 7
        for(int n = 0; n < tableau.length; n++){
            tableau[n] = new Stack();
            //sets each array space as a new stack
        }
        hand = new Stack<Card>();
        //creates a single pile for the hand pile
        talon = new Stack<Card>();
        //creates a single pile for the unused cards
        gui = new GuiMethods();
        //calls on GuiMethods class
        hand = makeHand();
        deal();    
        //calls on method deal
        moves = 0; //declares the initial # of moves
    }

    public Stack<Card> makeHand()
    {
        ArrayList<Card> deck = new ArrayList<Card>();
        //initializes a list to be filled with cards
        for(int k = 1; k <= 4; k++){
            for(int n = 1; n <= 13; n++){
                String suit = "";
                if(k == 1){
                    suit = "d"; //diamond suit
                }
                if(k == 2){
                    suit = "s"; //spade suit
                }
                if(k == 3){
                    suit = "c"; //club suit
                }
                if(k == 4){
                    suit = "h"; //heart suit
                }
                Card temp = new Card(n, suit);
                //creates a card with certain specifications into deck
                deck.add(temp);
            }
        }
        Stack<Card> hand = new Stack<Card>();
        //creates a stack of the cards to be in the hand pile
        while(deck.size() != 0)
        {
            if(deck.size() == 1){ 
                hand.push(deck.remove(0));
                //puts the last card in the hand
            }
            else
            {
                int rand = (int)(Math.random()*deck.size());
                //generates a random integer between 0 and 52
                hand.push(deck.remove(rand));
                //puts the card with the randomly generated index into hand
            }
        }
        return hand;    //returns the randomized hand
    }
    
    public void deal()
    {
        for(int k = 0; k < tableau.length; k++)
        {
            int count = 0;
            tableau[k] = new Stack<Card>();
            while(count < k + 1)
            {
                Card temp = hand.pop();
                tableau[k].push(temp);
                //adds card temp to tableau
                count++;
                //increments count
            }
            tableau[k].peek().turnFaceUp();
            //looks at last card in tableau at index k and turns up
        }
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
