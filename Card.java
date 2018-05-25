
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
	faceUp = false;    
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
 // card face methods
    public void turnFaceDown()
    {
	faceUp = false; 
    }
	
    public void turnFaceUp()
    {
	faceUp = true; 
    }
    public boolean isFaceUp()
    {
	return  isFaceUp;  
    }	    
	
    /**
     *Finds appropriate file name for gif corresponding to card based
     * on suit and rank
     *
     * @return name of the file for the appropriate Card
     */
    public String getFileName()
    {
        if (!isFaceUp)
	{
		return "backcard.gif"; //using escape sequence, not double slash
	}
        if (rank == 10) return "t" + suit + ".gif";
        if (rank == 11) return "j" + suit + ".gif";
        if (rank == 12) return "q" + suit + ".gif";
        if (rank == 13) return "k" + suit + ".gif";
        if (rank == 1) return "a" + suit + ".gif";
        return rank + suit + ".gif";
    }    
	    
}
