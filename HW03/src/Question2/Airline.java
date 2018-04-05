package Question2;
import java.util.*;
public class Airline {
	Passenger[] list;
	HashMap<Passenger, Integer> map;
	private HashSet<Integer> codeCheck;
	private int last;
	
	public Airline()
	{
		map = new HashMap<>();
		list = new Passenger[100];
		codeCheck = new HashSet<Integer>();
		Passenger max = new Passenger("max",100);
		list[0] = max;
		last = 1;
	}
	public void swap(int point1, int point2)
	{
		Passenger temp = list[point1];
		list[point1] = list[point2];
		list[point2] = temp;
		
		map.put(list[point1], point1);
		map.put(list[point2], point2);
	} 
	
	public void swim(int point)
	{
		int k=point;
		while(list[k].level > list[k/2].level)
		{
			swap(k,k/2);
			k=k/2;
		}
	}
	
	public int add(String name, int level)
	{
		Passenger pass = new Passenger(name, level);
		if(codeCheck.contains(pass.code))
			this.add(name, level);
		codeCheck.add(pass.code);
		if(last>=list.length)
		{
			Passenger[] newList = new Passenger[list.length*2];
			for(int i=0;i<list.length;i++)
			{
				newList[i] = list[i];
			}
			list = newList;
		}
		list[last] = pass;
		map.put(pass, last);
		swim(last);
		last++;
		return pass.code;
	}
	public void sink(int point)
	{
		int k = point;
		if(k*2>last-1)
			return;
		while(list[k].level<list[k*2].level || list[k].level < list[k*2+1].level)
		{
			
			if(list[k*2].level >list[k*2+1].level)
			{
				swap(k,k*2);
				if(k*2>last-1)
				{
					return;
				}
				k=k*2;
			}
			else
			{
			swap(k,k*2+1);
			if(k*2+1>last-1)
			{
				return;
			}
			k=k*2+1;
			}
		}
	}
	public boolean remove(String name, int level, int code)
	{
		Passenger p = new Passenger(name,level,code);
		if(map.get(p) == null)
		{
			return false;
		}
		int index = map.get(p);
		swap(index,last-1);
		list[last-1] = null;
		last--;
		sink(index);
		return true;
	}
	private Passenger removeMaxValue()
	{
		Passenger max = list[1];
		swap(1,last-1);
		list[last-1] = null;
		sink(1);
		return max;
	}
	public int size()
	{
		return last-1;
	}
	public ArrayList<String> getList(int k)
	{
		ArrayList<Passenger> saver = new ArrayList<>();
		ArrayList<String> end = new ArrayList<>();
		int counter = 0;
		if(k>last)
			k = last;
		for(Passenger p :list)
		{
			saver.add(p);
			end.add(p.name);
			if(counter == k)
				break;
			counter++;
		}
		end.remove(0);
		return end;
	}
	
}
