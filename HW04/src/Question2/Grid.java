package Question2;
import java.util.*;
public class Grid {
	Hashtable<Cell,Integer> cellsWithPoints = new Hashtable<>();
	Cell Player;
	int playerPoints;
	int size;
	
	public Grid(int size)
	{
		this.size = size;
		Player = new Cell(size);
		playerPoints = 0;
		Random gen = new Random();
		for(int i=0;i<size;i++)
		{
			Cell newCell = new Cell(size);
			while(Player.equals(newCell) || cellsWithPoints.containsKey(newCell))
			{
				newCell = new Cell(size);
			}
			int points = gen.nextInt(101)+1;
			cellsWithPoints.put(newCell,points);
		}
	}
	
	public boolean Move(int i,int j,int k)
	{
		Cell moveTo = new Cell(i,j,k,size);
		if(cellsWithPoints.containsKey(moveTo))
		{
			playerPoints +=cellsWithPoints.get(moveTo);
			Player = moveTo;
			cellsWithPoints.remove(moveTo);
			Cell randomHund = new Cell(size);
			if(cellsWithPoints.containsKey(randomHund))
			{
				int points = 100 + cellsWithPoints.get(randomHund);
				cellsWithPoints.put(randomHund, points);
			}
			cellsWithPoints.put(randomHund, 100);
			return true;
		}
		Player = moveTo;
		return false;
	}
	public String getCells()
	{
		Set<Cell> end = cellsWithPoints.keySet();
		String returned = "";
		for( Cell i : end)
		{
			returned += i.toString() + cellsWithPoints.get(i) + "points"+ "\n";
		}
		return returned;
	}
}
