package question3;
import java.util.*;
public class question3 {
	
	public static String moveToFront(String input)
	{
		LinkedList<Object> list = new LinkedList<>();
		for(int i=0;i<input.length();i++)
		{
			String character = input.substring(i, i+1);
			list.remove(character);
			list.addFirst(character);
		}
		return list.toString();
	}
	
	/*public static void main(String[] args)
	{
		System.out.println(moveToFront("aabbavdicbu"));
	}*/

}
