
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
    private String myType;
    private boolean myColor;

    public Card(int number, String type, boolean color)
    {
        myNumber = number; //set variables to instance of card
        myType = type;
        myColor = color;
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

    public boolean getColor()
    {
        return myColor;
    }

}
