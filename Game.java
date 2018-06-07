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
    public static void main(String[]args){
        MenuFrame menuF = new MenuFrame();

    }
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
        gui = new GuiMethods(this);
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

    public Card getFoundation(int k){
        if(foundation[k].isEmpty()){
            return null;
        }
        return foundation[k].peek();
    }

    public Stack<Card> getTableau(int k)
    {
        return tableau[k];
    }

    public Card getTalon(){
        if(talon.size() == 0)
        {
            return null;
        }
        return talon.peek();
    }

    public Card getHand(){
        if(hand.size() == 0){
            return null;
        }
        return hand.peek();
    }

    public void giveCard()
    {
            if(!hand.isEmpty())
            {
                Card temp = hand.pop();
                talon.push(temp);
                temp.turnFaceUp();
        }
    }

    public void resetHand()
    {
        while(!talon.isEmpty())
        {
            Card temp = talon.pop();
            temp.turnFaceDown();
            hand.push(temp);
        }
    }

    public void handPressed(){
        System.out.println("You pressed the hand pile");
        gui.unselect();
        if(!gui.isTalonSelected()&&!gui.isTableauSelected())
        {
            if(hand.isEmpty())
                resetHand();
            else
                giveCard();
        }
    }

    public void talonPressed(){
        System.out.print("You pressed the talon pile");
        if(!talon.isEmpty())
        {
            if(!gui.isTalonSelected())
                gui.selectTalon();
            else
                gui.unselect();
        }
    }

    public void foundationPressed(int k){
        System.out.println("foundation #" + k + "pressed");
        if(gui.isTalonSelected())
        {
            if(canAddToFoundation(talon.peek(), k))
            {
                Card temp = talon.pop();
                foundation[k].push(temp);
                gui.unselect();
            }
        }
        if(gui.isTableauSelected())
        {
            Stack<Card> selectedTableau = tableau[gui.selectedTableau()];
            if(canAddToFoundation(selectedTableau.peek(), k))
            {
                Card temp = selectedTableau.pop();
                foundation[k].push(temp);
                if(!selectedTableau.isEmpty())
                {
                    selectedTableau.peek().turnFaceUp();
                }
                gui.unselect();
            }
        }
    }

    public void tableauPressed(int k){
        System.out.println("tableau#" + k + " pressed");
        if(gui.isTalonSelected()){
            Card temp = talon.peek();
            if(canAddToTableau(temp, k)){
                tableau[k].push(talon.pop());
                tableau[k].peek().turnFaceUp();
            }
            gui.unselect();
            gui.selectTableau(k);
        }
        else if(gui.isTableauSelected()){
            int lastTableau = gui.selectedTableau();
            if(k != lastTableau)
            {
                Stack<Card> temp = removeFaceUpCards(lastTableau);
                if(canAddToTableau(temp.peek(), k))
                {
                    addToTableau(temp,k);
                    if(!tableau[lastTableau].isEmpty()){
                        tableau[lastTableau].peek().turnFaceUp();

                    }
                    gui.unselect();
                }
                else{
                    addToTableau(temp, lastTableau);
                    gui.unselect();
                    gui.selectTableau(k);
                }
            }
            else{
                gui.unselect();
            }
        }
        else{
            gui.selectTableau(k);
            tableau[k].peek().turnFaceUp();
        }
    }

    private boolean canAddToTableau(Card c, int k)
    {
        Stack<Card> pile = tableau[k];
        if(pile.isEmpty())
            return(c.getNumber() == 13);
        Card top = pile.peek();
        if(!top.isFaceUp())
            return false;
        return (c.isBlack() != top.isBlack())&&
                (c.getNumber() == top.getNumber()-1);
    }

    private Stack<Card> removeFaceUpCards(int k){
        Stack<Card> card = new Stack<Card>();
        while(!tableau[k].isEmpty() && tableau[k].peek().isFaceUp())
        {
            card.push(tableau[k].pop());
        }
        return card;
    }

    private void addToTableau(Stack<Card> c, int k)
    {
        while (!c.isEmpty())
        {
            tableau[k].push(c.pop());
        }
    }

    private boolean canAddToFoundation(Card c, int k)
    {
        if (foundation[k].isEmpty())
            return (c.getNumber() == 1);
        Card temp = foundation[k].peek();
        return (temp.getNumber() + 1 == c.getNumber())
                && (temp.getSuit().equals(c.getSuit()));
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
        boolean won = false;    //won intialized
        for(int k = 0; k < foundation.length; k++){
            Card temp = foundation[k].peek();   //looks at last card
            if(temp.getNumber() == 13)
            {
                won = true;     //won is true
            }
            else
            {
                won = false;    //won is false
                break;      //breaks out of loop
            }
        }
        return won;
    }

}
