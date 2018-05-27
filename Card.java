/**
 * FINAL PROJECT
 * John Yu, Varshini Sathish
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
    private String mySuit;  //either d,c,s, or h
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
        return  faceUp;  
    }       

    //if black color
    public boolean isBlack()
    {
        return (mySuit.equals("s") || mySuit.equals("c"));      
    }    

    /**
     *Finds appropriate file name for gif corresponding to card based
     * on suit and myNumber
     *
     * @return name of the file for the appropriate Card
     */
    public String getFileName()
    {
        if (!faceUp)
        {
            return "backcard.gif"; //using escape sequence, not double slash
        }
        if (myNumber == 10) return "t" + mySuit + ".gif";
        if (myNumber == 11) return "j" + mySuit + ".gif";
        if (myNumber == 12) return "q" + mySuit + ".gif";
        if (myNumber == 13) return "k" + mySuit + ".gif";
        if (myNumber == 1) return "a" + mySuit + ".gif";
        return myNumber + mySuit + ".gif";
    }    

}
