package Question2;
import java.util.*;
public class Airlineold {
	ArrayList<Passenger> list;
	HashMap<Passenger, Integer> map;
	private HashSet<Integer> codeCheck;
	
	public Airlineold()
	{
		map = new HashMap<>();
		list = new ArrayList<Passenger>();
		codeCheck = new HashSet<Integer>();
		Passenger max = new Passenger("max",100);
		list.add(max);
	}
	public void swap(int point1, int point2)
	{
		Passenger temp = list.get(point1);
		list.set(point1, list.get(point2));
		list.set(point2, temp);

		map.put(list.get(point1),point1);
		map.put(list.get(point2),point2);
	}
	
	public void swim(int point)
	{
		int k = point;
		while(list.get(k).level>list.get(k/2).level)
		{
			swap(k, k/2);
			k=k/2;
		}
	}
	
	public int add(String name, int level)
	{
		Passenger pass = new Passenger(name, level);
		if(codeCheck.contains(pass.code))
			this.add(name, level);
		codeCheck.add(pass.code);
		list.add(pass);
		map.put(pass,list.size()-1);
		if(list.size() !=2)
			this.swim(list.size()-1);
		return pass.code;
	}
	public void sink(int point)
	{
		int k = point;
		if(list.size() ==1 || list.size()==2)
		{
			return;
		}		
		if(list.size()%2!=0)
		{
			if(list.get(point).level <list.get(point*2).level)
				swap(point,point*2);
			return;
		}
		while(list.get(k).level<list.get(k*2).level || list.get(k).level<list.get(k*2+1).level)
		{
			if(list.get(k*2).level>list.get(k*2+1).level)
			{
				swap(k,k*2);
				k=k*2;
				if(k*2>=list.size()-1)
					return;
			}
			else if(list.get(k*2).level<list.get(k*2+1).level)
			{
				swap(k,k*2+1);
				k=k*2;
				if(k*2>=list.size()-1)
					return;
			}
		}
	}
	
	public boolean remove(String name, int level, int code)
	{
		Passenger pass = new Passenger(name,level,code);
		if(map.get(pass) == null)
			return false;
		int index = map.get(pass);
		swap(index,list.size()-1);
		list.remove(list.size()-1);
		sink(1);
		return true;
	}
	private Passenger removeMaxValue()
	{
		Passenger pass = list.get(1);
		swap(1,list.size()-1); ////////////
		list.remove(list.size()-1);////////
		sink(1);
		return pass;
	}
	
	public int size()
	{
		return list.size()-1;	
	}
	public ArrayList<String> getList(int k)
	{
		ArrayList<Passenger> save = new ArrayList<>();
		ArrayList<String> topK = new ArrayList<>();
		for(int i=0;i<k || i<list.size()-1;i++)
		{
			Passenger p =removeMaxValue();
			save.add(p);
			topK.add(p.name);
		}
		for(Passenger p:save)
			list.add(p);
		return topK;
	}
	
}
