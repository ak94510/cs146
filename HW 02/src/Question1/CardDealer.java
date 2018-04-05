package Question1;

public class CardDealer {
	
	public static void main(String [] args)
	{
		int numberOfRuns = Integer.parseInt(args[0]);
		int numberOfPlayers = Integer.parseInt(args[1]);
		float goodness = Float.parseFloat(args[2]);
		float straightCounter = 0;
		float total =0;
		for(int j=0;j<numberOfRuns;j++)
		{
			Deck deck = new Deck();
			deck.shuffle(goodness);
			Hand[] players = new Hand[numberOfPlayers];
			for(int i=0;i<players.length;i++)
			{
				Hand theHand = new Hand();
				players[i] = theHand;
			}
			int size = deck.ND.size();
			for(int i=0;i<size;i++)
			{
				players[i%numberOfPlayers].addCard(deck.dealOne());
			}
		
			for(Hand a : players)
			{
				total++;
				if(a.hasStraight(3, true))
					straightCounter++;
			}
		}
		float answer = straightCounter/total*100;
		System.out.println((int)answer + "%");
	}

}
