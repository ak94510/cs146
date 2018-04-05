package Question2;
import java.util.*;
public class question2Class {
	
	public static void main(String[] args)
	{
		int[] a = new int[Integer.parseInt(args[0])];
		int[] b = new int[Integer.parseInt(args[1])];
		int iterations = Integer.parseInt(args[2]);
		long startTime = System.currentTimeMillis();
		for(int j =0;j<iterations;j++)
		{
			ArrayList<Integer> nonDups = new ArrayList<>();
			int maxLength;
			if(a.length>b.length)
			{
				maxLength = a.length;
			}
			else
			{
				maxLength = b.length;
			}
			Random gen = new Random();
		
			for(int i=0;i<a.length;i++)
			{
				a[i] = gen.nextInt(maxLength+1);
			}
			for(int i=0;i<b.length;i++)
			{
				b[i] = gen.nextInt(maxLength+1);
			}
			Arrays.sort(a);
			Arrays.sort(b);
			int aIndex = 0;
			int bIndex = 0;
			while(aIndex<a.length && bIndex<b.length)
			{
				int aCompare = a[aIndex];
				int bCompare = b[bIndex];
				if(aCompare>bCompare)
				{
					nonDups.add(b[bIndex++]);
				}
				else if(aCompare<bCompare)
				{
					nonDups.add(a[aIndex++]);
				}
				else
				{
					while(a[aIndex] == bCompare && aIndex<a.length)
					{
						aIndex++;
						if(aIndex == a.length)
							break;
					}
					while(b[bIndex] == aCompare)
					{
						bIndex++;
						if(bIndex == b.length)
							break;
					}
				}
			}
			if(aIndex==a.length)
			{
				for(int i= bIndex; i<b.length;i++)
					nonDups.add(b[i]);
			}
			if(bIndex==a.length)
			{
				for(int i=aIndex;i<a.length;i++)
					nonDups.add(a[i]);
			}
System.out.println(j);
		}
		System.out.println(System.currentTimeMillis()-startTime);
	}

	
}
