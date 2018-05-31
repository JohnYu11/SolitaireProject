/**
 * FINAL PROJECT
 * Fiona Harrington, Varshini Sathish, John Yu
 * 5/7/2018
 * Description: allows the user to move around cards on the board and
 * play the game under the given rules.
 * Purpose: to facilitate the playing of the game.
 */
import java.util.*;
public class Game
{
    public static void main(String[]args){
        new Game(); //creates an instance of the game
    }
    private Stack<Card>[]foundation;
    //the array for the stacks for the 4 suit piles
    private Stack<Card>[] tableau;
    //the array for the stacks for the 7 random piles
    private Stack<Card> hand;
    //the stack for the free cards
    private Stack<Card> talon;
    //the stack for the unused free cards
    private SolitaireGui gui;
    //creates an object for SolitaireGui class
    public int moves;
    //the # of moves taken so far
    private MenuGui mui;
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
        gui = new SolitaireGui(this);
        //calls on SolitaireGui class
        hand = makeHand();
        //makes the pile of free cards
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
                String suit = "";   //suit initialized as empty string
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
                deck.add(temp); //adds cards to deck
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
            int count = 0;  //count initialized at 0
            tableau[k] = new Stack<Card>();     //tableau at index k is new stack of cards for 7 piles
            while(count < k + 1)
            {
                Card temp = hand.pop();     //removes a card from the hand pile and returns it to temp
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
            return null;        //if foundation empty then null is returned
        }
        return foundation[k].peek();        //looks at the top card of foundation if not empty  
    }

    public Stack<Card> getTableau(int k)
    {
        return tableau[k];      //gets the stack tableau at the index k
    }

    public Card getTalon(){
        if(talon.size() == 0)
        {
            return null;        //if talon is empty then null returned
        }
        return talon.peek();        //looks at the last card in the talon
    }

    public Card getHand(){
        if(hand.size() == 0){
            return null;        //if hand is empty then null is returned
        }
        return hand.peek();     //gets the last card in the hand
    }

    public void giveCard()      //from the new card pile
    {
        for(int k = 0; k < 3; k++){
            if(!hand.isEmpty())
            {
                Card temp = hand.pop();     //removes a card from the hand pile and returns it to temp
                talon.push(temp);
                temp.turnFaceUp();      
            }
        }
    }

    public void resetHand()
    {
        while(!talon.isEmpty())         //while there are still cards in talon
        {
            Card temp = talon.pop();    //removes a card from the talon pile and returns it to temp
            temp.turnFaceDown();        //turn top card face dowm
            hand.push(temp);            
        }
    }

    public void handPressed(){
        System.out.println("You pressed the hand pile");    
        gui.unselect();
        if(!gui.isTalonSelected()&&!gui.isTableauSelected()) 
        {
            if(hand.isEmpty())      //if user went through all the cards
                resetHand();        //reset new card pile (in the same order as before)
            else 
                giveCard();         //if there are cards left, give top card
        }
    }

    public void talonPressed(){
        System.out.print("You pressed the talon pile");
        if(!talon.isEmpty())                //if there are more cards
        {
            if(!gui.isTalonSelected())      //if it is unselected, select the card
                gui.selectTalon();
            else
                gui.unselect();             //if already selected, unselect
        }
    }

    public void foundationPressed(int k){
        System.out.println("foundation #" + k + "pressed");
        if(gui.isTalonSelected())
        {
            if(canAddToFoundation(talon.peek(), k))     //checks to see if card can be added to foundation (far right w/aces)
            {
                Card temp = talon.pop();
                foundation[k].push(temp);               //add the new card to the foundation
                gui.unselect();                         //unselect the card
            }
        }
        if(gui.isTableauSelected())                     //if user wants card to be added to tableau
        {
            Stack<Card> selectedTableau = tableau[gui.selectedTableau()];       
            if(canAddToFoundation(selectedTableau.peek(), k))       //checks to see if card can be added to foundation
            {
                Card temp = selectedTableau.pop();       //removes a card from the selected tableau and returns it to temp
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
        return true;
    }
}
