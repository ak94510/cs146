package Question2;
import java.util.*;
public class Node {
	ArrayList<String> adjNodes = new ArrayList<>();
	ArrayList<Integer> adjWeights = new ArrayList<>();
	ArrayList<Integer> depatrureTime = new ArrayList<>();
	int distToOrigin = Integer.MAX_VALUE;
	String edgeTo;
	String name ="";
	boolean visited = false;
	public Node(String name)
	{
		this.name=name;
	}
	
	public boolean equals(Object that)
	{
		Node compare = (Node)that;
		if(this.name.equals(compare.name))
		{
			return true;
		}
		return false;
	}
	public String toString()
	{
		return name;
	}

}
