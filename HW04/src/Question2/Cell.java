package Question2;
import java.util.*;
public class Cell {
	int i;
	int j;
	int k;
	
	public Cell(int limit)
	{
		Random gen = new Random();
		i = gen.nextInt(limit)+1;
		j = gen.nextInt(limit)+1;
		k = gen.nextInt(limit)+1;	
	}
	
	public Cell(int i,int j,int k,int limit)
	{
		if(i<=limit &&j<=limit&&k<=limit)
		{
		this.i = i;
		this.j = j;
		this.k = k;
		}
		else
		{
			System.out.println("Cell out of bounds.");
		}
	}
	
	public boolean equals(Object thing)
	{
		Cell that = (Cell)thing;
		if(that.i==this.i && that.j==this.j && that.k==this.k)
			return true;
		return false;
	}
	public String toString()
	{
		return "( "+i+" , "+j+" , "+k+" ) ";
	}
	public int hashCode()
	{
		return i+j+k;
	}
}
