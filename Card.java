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
        //set variables to instance of card
        myNumber = number; 
        mySuit = suit;  
        faceUp = false;    
    }

    /**GET VARIABLES**/

    public int getNumber()
    {
        return myNumber;    //returns card #
    }
    
    public String getSuit(){
        return mySuit;  //returns card type
    }

    // card face methods
    public void turnFaceDown()
    {
        faceUp = false;     //turns card upside down
    }

    public void turnFaceUp()
    {
        faceUp = true;  //turns card right side up
    }

    public boolean isFaceUp()
    {
        return faceUp;      //returns whether card is faceUp
    }       

    //if black color
    public boolean isBlack()
    {
        return (mySuit.equals("s") || mySuit.equals("c"));      //returns whether card is black
    }    

    /**
     *Finds appropriate file name for gif corresponding to card based
     * on suit and myNumber
     *
     * @return name of the file for the appropriate Card
     */
    public String getFileName()
    {
        if (!faceUp)    //
        {
            return "CardImages/backcard.gif"; //using escape sequence, not double slash
        }
        if (myNumber == 10) return "CardImages/t" + mySuit + ".gif";
        if (myNumber == 11) return "CardImages/j" + mySuit + ".gif";
        if (myNumber == 12) return "CardImages/q" + mySuit + ".gif";
        if (myNumber == 13) return "CardImages/k" + mySuit + ".gif";
        if (myNumber == 1) return "CardImages/a" + mySuit + ".gif";
        return "CardImages/"+ myNumber + mySuit + ".gif";
    }    

}
