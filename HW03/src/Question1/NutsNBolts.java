package Question1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class NutsNBolts {
	
	public static ArrayList<Integer> nuts = new ArrayList<>();
	public static ArrayList<Integer> bolts = new ArrayList<>();
	
	public static void sortNutsNBolts(int bottomBound, int topBound)
	{
		int i = bottomBound;
		int j = topBound;
		int pivot = bolts.get(i);
		while(i<=j)
		{
			while(nuts.get(i)<pivot)
			{
				i++;
			}
			while(nuts.get(j)>pivot)
			{
				j--;
			}
			if(i<=j)
			{
				int holder = nuts.get(i);
				nuts.set(i, nuts.get(j));
				nuts.set(j, holder);
				i++;
				j--;
			}
		}
		
		i = bottomBound;
		j = topBound;
		pivot = nuts.get(nuts.indexOf(pivot));
		while(i<=j)
		{
			while(bolts.get(i)<pivot)
			{
				i++;
			}
			while(bolts.get(j)>pivot)
			{
				j--;
			}
			if(i<=j)
			{
				int holder = bolts.get(i);
				bolts.set(i, bolts.get(j));
				bolts.set(j, holder);
				i++;
				j--;
			}
		}
        if (bottomBound < j)
            sortNutsNBolts(bottomBound, j);
       if (i < topBound)
            sortNutsNBolts(i, topBound);

		
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Question1 a = new Question1();
		nuts = a.readFile(args[0]);
		bolts = a.readFile(args[1]);
		System.out.println(nuts);
		System.out.println(bolts);
		sortNutsNBolts(0,bolts.size()-1);
		System.out.println(nuts);
		System.out.println(bolts);
	}
}
