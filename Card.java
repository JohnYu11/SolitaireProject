
/**
 * FINAL PROJECT
 * Fiona Harrington
 * 4/26/2018
 * 
 * Description: This class represents the attributes 
 * of a card with a given number and suit.
 * 
 * Purpose: These cards are used to fill arrays and
 * can be used to compare to other cards.
 */
public class Card
{
    private int myNumber; //initialize the attributes of a card
    private String mySuit;
    private boolean faceUp; //true if faceUp, false otherwise	

    public Card(int number, String suit)
    {
        myNumber = number; //set variables to instance of card
        mySuit = suit;
    }

    /**GET VARIABLES**/
    
	public int getNumber()
    {
        return myNumber;
    }

    public String getType()
    {
        return myType;
    }
 
    public void isFaceDown()
    {
	faceUp= false; 
    }
	
    public void isFaceUp()
    {
	    faceUp=true; 
    }
}
