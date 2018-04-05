package Question1;
import java.util.*;
public class Deck {

	public ArrayList<Card> ND = new ArrayList<>();
	private ArrayList<Card> D = new ArrayList<>();
	public Deck()
	{
		for(int suit=1;suit<=4;suit++)
		{
			for(int value=2;value<=14;value++)
			{
				Card aCard = new Card(suit,value);
				ND.add(aCard);
			}
		}
	}
	
	public Card dealOne()
	{
		Card drawn = ND.remove(0);
		D.add(drawn);
		drawn.dealt = true;
		return drawn;
	}
	
	public void print()
	{
		System.out.println("Not Dealt");
		for(int i=0;i<ND.size();i++)
		{
			System.out.print(ND.get(i)+ ", ") ;
			System.out.println("");
		}
		
		System.out.println("Dealt");
		for(int i=0;i<D.size();i++)
		{
			System.out.print(D.get(i)+ ", ") ;
		}
	}
	
	public void shuffle(float goodness)     
	{
		Random gen = new Random();
		if(goodness>1 || goodness<0)
			return;
		float cardsShuffled =ND.size() - goodness *ND.size();
		for(int i=2;i<=(int)cardsShuffled;i = i+2)
		{
			int index1 = gen.nextInt(ND.size());
			int index2 = gen.nextInt(ND.size());
			Card card1 = ND.get(index1);
			Card card2 = ND.get(index2);
			ND.set(index1, card2);
			ND.set(index2, card1);
		}
		
	}
}
