package Question2;
import java.util.*;
public class customerInterface {
	public static void main(String[] args)
	{
		Airline airline = new Airline();
		Scanner scan = new Scanner(System.in);
		boolean gotAnswer = true;
		do
		{
			System.out.println("\nWelcome to your we2lo airline! Please enter \"Requset flight\" , \"Cancel flight\", or \"Passenger List\".");
			String input = scan.nextLine().toLowerCase();
			if(input.equals("request flight") || input.equals("cancel flight"))
				{
				boolean request = input.equals("request flight");
				gotAnswer = true;
				System.out.println("Please enter your name.");
				String name = scan.nextLine();
				int level = 0;
				do
				{
					System.out.println("Please enter your frequent flyer level as super, platinum, gold, or silver.");
					String status = scan.nextLine().toLowerCase();
					if(status.equals("super"))
					{
						gotAnswer = true;
						level =3;
					}
					else if(status.equals("platinum"))
					{
						gotAnswer = true;
						level =2;
					}
					else if(status.equals("gold"))
					{
						gotAnswer = true;
						level = 1;
					}
					else if(status.equals("silver"))
					{
						gotAnswer = true;
						level =0;
					}
					else
					{
						gotAnswer =false;
						System.out.println("Your input does not match proper format.");
					}
				}while(!gotAnswer);
				if(request)
				{
					System.out.println("Your conformation code is " + airline.add(name, level));
				}
				else
				{
					int code =0;
					do
					{
					System.out.println("Please enter your conformation code.");
						try
						{
						gotAnswer = true;
						code = scan.nextInt();
						}
						catch (InputMismatchException x)
						{
							System.out.println("Your conformation code does not match proper format.");
							gotAnswer = false;
						}
					}while(!gotAnswer);
					
					if(airline.remove(name, level, code))
					{
					System.out.println("Thank you, you have been removed.");
					}
					else
						System.out.println("No passenger could be found");
				}
				
			}
			else if(input.equals("passenger list"))
			{
				gotAnswer = true;
				int numberOf = 0;
				do
				{
					System.out.println("Please enter the number of passengers.");
					try
					{
						gotAnswer = true;
						numberOf = scan.nextInt();
						if(numberOf > airline.size())
						{
							System.out.println("You asked for too many seats.");
							numberOf = airline.size();
						}
					}
					catch (InputMismatchException x)
					{
						System.out.println("Your input does not match proper format.");
						gotAnswer = false;
					}
				}while(!gotAnswer);
				int seatsLeft = airline.size() - numberOf;
				ArrayList<String> flyers = airline.getList(numberOf);
				System.out.println("The passenger list is" + flyers + "with " + seatsLeft + " available seats.");
			}
		} while(true);
	}

}
