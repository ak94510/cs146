package Question1;
import java.util.*;
public class Maze {
	HashSet<Node> visited = new HashSet<>();
	ArrayList<Node> graph = new ArrayList<>();
	public Maze(int n)
	{
		for(int x=1;x<=n;x++)
		{
			for(int y=1;y<=n;y++)
			{
				Node newNode = new Node(x,y);
				if(x+1!=n+1)
				{
					Node adj1 = new Node(x+1,y);
					newNode.adjNodes.add(adj1);
				}
				if(y+1!=n+1)
				{
					Node adj2 = new Node(x,y+1);
					newNode.adjNodes.add(adj2);
				}
				if(x-1!=0)
				{
					Node adj3 = new Node(x-1,y);
					newNode.adjNodes.add(adj3);
				}
				if(y-1!=0)
				{
					Node adj4 = new Node(x,y-1);
					newNode.adjNodes.add(adj4);
				}
				Collections.shuffle(newNode.adjNodes);
				graph.add(newNode);
			}
		}
		Random gen = new Random();
		Node start = graph.get(gen.nextInt(n*n));
		while(visited.size()!= n*n)
		{
			visited.add(start);
			Node compare = graph.get(graph.indexOf((start)));
			for(Node d: start.adjNodes)
			{
				if(!visited.contains(d))
				{
					start.connectedNodes.add(d);
					Node newStart = graph.get(graph.indexOf(d));
					newStart.connectedNodes.add(start);
					start =newStart;
					break;
				}
			}
			
			if(start.equals(compare))
			{
				for(Node p :visited)
				{
					for(Node d: p.adjNodes)
					{
						if(!visited.contains(d))
						{
							start=graph.get(graph.indexOf(p));
						}
					}
				}
			}
		}
	}
	
	public void printGraph()
	{
		for(Node n : graph)
		{
			System.out.print("Node "+ "(" + n.x + "," + n.y + ")" + " is connected to ");
			for(Node p : n.connectedNodes)
			{
				System.out.print("(" + p.x + "," +p.y +")" + "and ");
			}
			System.out.println("");
		}
			
	}
	public static void main(String[] args)
	{
		int size = Integer.parseInt(args[0]);
		Maze theGlade = new Maze(size);
		theGlade.printGraph();
	}
}
