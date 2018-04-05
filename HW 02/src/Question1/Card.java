package Question1;

public class Card implements Comparable {
	public boolean dealt;
	public int suit;
	public int value;
	
	public Card(int theSuit, int theValue)
	{
		suit = theSuit;
		value = theValue;
		dealt = false;
	}
	
	public void print()
	{
		if(value ==11)
			System.out.print("Jack");
		else if(value == 12)
			System.out.print("Queen");
		else if(value == 13)
			System.out.print("King");
		else if(value == 14)
			System.out.print("Ace");
		else
			System.out.print(value);
		
		if(suit == 1)
			System.out.print(" of Clubs");
		if(suit == 2)
			System.out.print(" of Dimonds");
		if(suit == 3)
			System.out.print(" of Hearts");
		if(suit == 4)
			System.out.print(" of Spades");
	}
	
	public int compareTo(Object that)
	{
		Card That = (Card)that;
		return this.value - That.value;
	}
	


}
