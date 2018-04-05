package Question2;
import java.util.*;
public class LandOfCandy {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Land Of Candy!!!!!!!!!!!!! \n \nPlease enter the size of your grid!");
		int size = Integer.parseInt(in.nextLine());
		Grid grid = new Grid(size);
		while(true)
		{
			System.out.println("Enter the next position (or p to print current board):");
			String answer = in.nextLine();
			if(answer.equals("p"))
			{
				System.out.println(grid.getCells());
			}
			else
			{
				String[] ijk = answer.split(" ");
				if(grid.Move(Integer.parseInt(ijk[0]), Integer.parseInt(ijk[1]), Integer.parseInt(ijk[2])))
				{
					System.out.println("Congradulations, your new score is "+ grid.playerPoints);
				}
				else
				{
					System.out.println("Sorry, the point you went to is empty.");
				}
			}
		}
	}

}
