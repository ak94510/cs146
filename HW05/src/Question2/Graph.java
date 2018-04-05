package Question2;
import java.util.*;
import java.io.*;
public class Graph {
	ArrayList<Node> airports = new ArrayList<>();
	ArrayList<String> airportNames = new ArrayList<>();
	HashMap<String, Integer> layovers = new HashMap<>();
	public Graph(String fileName, boolean thirtyLayover, String layoverFileName) throws FileNotFoundException
	{
		File file = new File(fileName);
		Scanner input = new Scanner(file);
		if(!layoverFileName.equals("no file"))
		{
			File connectionFile = new File(layoverFileName);
			Scanner newInput = new Scanner(connectionFile);
			while(newInput.hasNextLine())
			{
				String line = newInput.nextLine().replaceAll(" ", "");
				String[] info = line.split(",");
				String name = info[0];
				Integer delay = Integer.parseInt(info[1]);
				layovers.put(name, delay);
			}
		}
		while(input.hasNextLine())
		{
			String line = input.nextLine().replaceAll(" ", "");
			String[] info = line.split(",");
			String origin = info[0];
			String destination = info[1];
			int startTime = Integer.parseInt(info[2]);
			int arrivalTime = Integer.parseInt(info[3]);
			if(thirtyLayover)
				arrivalTime+=30;
			if(layovers.containsKey(destination))
			{
				arrivalTime+=layovers.get(destination);
			}
			Node airport = new Node(origin);
			Node endport = new Node(destination);
			if(airports.contains(airport))
			{
				airport = airports.get(airports.indexOf(airport));
				airport.adjNodes.add(destination);
				airport.depatrureTime.add(startTime);
				airport.adjWeights.add(arrivalTime);
			}
			else
			{
			airport.adjNodes.add(destination);
			airport.depatrureTime.add(startTime);
			airport.adjWeights.add(arrivalTime);
			airports.add(airport);
			}
			if(!airports.contains(endport))
			{
				airports.add(endport);
			}
		}
		for(Node n :airports)
		{
			airportNames.add(n.name);
		}
	}
	
	public void ShortestPath(String origin,String destination, int startTime)
	{
		Node start = airports.get(airportNames.indexOf(origin));
		start.distToOrigin = 0;
		ArrayList<Node> queue = new ArrayList<>();
		queue.add(start);
		while(!queue.isEmpty())
		{
			start = queue.remove(0);
			start.visited=true;
			for(int n=0;n<start.adjNodes.size();n++)
			{
				Node next = airports.get(airportNames.indexOf(start.adjNodes.get(n)));
				if(!next.visited)
				{
					queue.add(next);
					int distTo = start.adjWeights.get(n);
					int departTime = start.depatrureTime.get(n);
					startTime = start.distToOrigin;
					if(next.distToOrigin>distTo && departTime>startTime)
					{
						next.edgeTo=start.name;
						next.distToOrigin = distTo;
					}
				}
			}
		}
		start = airports.get(airportNames.indexOf(origin));
		Node end = airports.get(airportNames.indexOf(destination));
		System.out.print(end.name + "<-");
		while(end!=start)
		{
			System.out.print(end.edgeTo + "<-");
			end = airports.get(airportNames.indexOf(end.edgeTo));
		}

		
	}
	public static void main(String[] args) throws FileNotFoundException
	{
		Graph airMap;
		if(args.length==1)
		{
			airMap = new Graph(args[0], true, "no file");
		}
		else
		{
			airMap = new Graph(args[0], true, args[1]);
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your origin in UpperCase");
		String origin = input.nextLine();
		System.out.println("Please input your destination in UpperCase");
		String dest = input.nextLine();
		System.out.println("Please input your departure time");
		int time = input.nextInt();
		airMap.ShortestPath(origin,dest,time);
	}
}
