package Question1;
import java.util.*;
public class Hand {
	private ArrayList<Card> theHand;
	
	public Hand()
	{
		theHand = new ArrayList<Card>();
	}
	
	public void print()
	{
		System.out.println(theHand);
	}
	
	public void addCard(Card card)
	{
		theHand.add(card);
	}
	
	public void sortBySuit()
	{
		ArrayList<Card> sorted = new ArrayList<>();
		for(int i=0;i<theHand.size();i++)
		{
			if(theHand.get(i).suit == 3)
				sorted.add(theHand.get(i));
			if(theHand.get(i).suit == 2)
				sorted.add(0,theHand.get(i));				
		}
		for(int i=0;i<theHand.size();i++)
		{
			if(theHand.get(i).suit == 4)
				sorted.add(theHand.get(i));
			if(theHand.get(i).suit == 1)
				sorted.add(0,theHand.get(i));				
		}
		TreeSet<Card> finalSort = new TreeSet<>(sorted);
		theHand = new ArrayList<Card>(finalSort);
	}
	
	public void sortByValue()
	{
		TreeSet<Card> initialSort = new TreeSet<>(theHand);
		theHand = new ArrayList<>(initialSort);
		ArrayList<Card> sorted = new ArrayList<>();
		int counter = 0;
		for(int i=0;i<theHand.size();i++)
		{
			if(theHand.get(i).suit == 3)
				sorted.add(theHand.get(i));
			if(theHand.get(i).suit == 1)
			{
				sorted.add(0,theHand.get(i));
				counter++;
			}
		}
		for(int i=0;i<theHand.size();i++)
		{
			if(theHand.get(i).suit == 4)
				sorted.add(theHand.get(i));
			if(theHand.get(i).suit == 2)
			{
				sorted.add(0,theHand.get(i));	
				counter++;
			}
		}
		
		for(int i=counter-1;i>=0;i--)
		{
			theHand.set(i, sorted.get(counter-1-i));
		}
		for(int i=counter;i<sorted.size();i++)
		{
			theHand.set(i, sorted.get(i));
		}
	}
	
	public boolean hasStraight(int length,boolean sameSuit)
	{
		if(!sameSuit)
		{
			TreeSet<Integer> treeValues = new TreeSet<>();
			int counter = 1;
			for(int i=0;i<theHand.size();i++)
			{
				treeValues.add(theHand.get(i).value);
			}
			ArrayList<Integer> values = new ArrayList<>(treeValues);
			for(int i=0;i<values.size()-1;i++)
			{
				if(values.get(i+1)-values.get(i) == 1)
					counter++;
				else
				{
					if(counter>=length)
						return true;
					else
						counter =1;
				}
			}
		}
		else
		{
			this.sortByValue();
			int counter =1;
			for(int i=0;i<theHand.size()-1;i++)
			{
				int compareValue = theHand.get(i+1).value - theHand.get(i).value;
				int compareSuit = theHand.get(i+1).suit - theHand.get(i).suit;
				if(compareValue == 1 && compareSuit ==0)
				{
					counter++;
				}
				else
				{
					if(counter>=length)
						return true;
					counter =1;
				}
			}
		}
		return false;
	}
}
