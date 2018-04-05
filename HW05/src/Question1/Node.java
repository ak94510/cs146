package Question1;
import java.util.*;
public class Node {
	public ArrayList<Node> adjNodes = new ArrayList<>();
	public HashSet<Node> connectedNodes = new HashSet<>();
	int x=0;
	int y=0;
	public Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void addAdj(Node n)
	{
		adjNodes.add(n);
	}
	public boolean equals(Object that)
	{
		Node n = (Node)that;
		if(n.x==x &&n.y==y)
		{
			return true;
		}
		return false;
	}
	public int hashCode()
	{
		return x+y;
	}

}
