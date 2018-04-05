package Question1;
import java.util.*;
import java.io.*;
public class PlagerismCheck {
	static HashMap<Integer, Integer> absoluteEnd = new HashMap<>();
	static HashMap<String, Integer> map = new HashMap<>();
	public static void readFile(File fileName) throws FileNotFoundException
	{
		Scanner gen = new Scanner(fileName);
		while(gen.hasNextLine())
			{
			String line = gen.nextLine();
			int textNumber = 0;
			String text = "";
			textNumber = Integer.parseInt(line.substring(0, line.indexOf(":")));
			if(line.substring(line.length()-1,line.length()).equals("\""))
			{
				text += line.substring(line.indexOf("\"")+1,line.length()-1);
			}
			else
			{
				text += line.substring(line.indexOf("\"")+1,line.length());
				line = gen.nextLine();
			}
			while(!line.substring(line.length()-1,line.length()).equals("\""))
			{
				text+= line + " ";
				line = gen.nextLine();
				if(line.substring(line.length()-1,line.length()).equals("\""))
				{
					text+=line.substring(0, line.length()-1);
				}
			}
			map.put(text, textNumber);
		}
	}
	public static ArrayList<String> tokenize(String justText)
	{
		String[] words = justText.split(" ");
		ArrayList<String> end = new ArrayList<String>();
		for(int i=0;i<words.length;i++)
		{
			end.add(words[i]);
		}
		return end;
	}
	
	public static void parser(ArrayList<String> input,int size,int fileNumber)
	{
		ArrayList<String> queue = new ArrayList<>();
		for(int i=0;i<input.size();i++)
		{
			if(i<size)
				queue.add(input.remove(0));
			else
			{
			queue.remove(0);
			queue.add(input.get(i));
			}
			if(i>=size-1)
			{
				absoluteEnd.put(queue.hashCode(), fileNumber);
			}
			
		}
	}
	public static void SOP(Object a)
	{
		System.out.println(a);
	}
	public static void main(String[] args) throws FileNotFoundException
	{
		String data =args[0];
		String doc = args[1];
		int size = Integer.parseInt(args[2]);
		File file = new File(data);
		readFile(file);
		Set<String> text = map.keySet();
		for(String a :text)
		{
			int mapTo = map.get(a);
			ArrayList<String> tokens = PlagerismCheck.tokenize(a);
			PlagerismCheck.parser(tokens,size,mapTo);
		}
		
		File toBeChecked = new File(doc);
		Scanner in = new Scanner(toBeChecked);
		String target = "";
		while(in.hasNextLine())
		{
			target += in.nextLine()+ " ";
		}
		ArrayList<String> wordsOfTarget = PlagerismCheck.tokenize(target);
		ArrayList<String> queue = new ArrayList<>();
		for(int i=0;i<wordsOfTarget.size();i++)
		{
			if(i<size)
				queue.add(wordsOfTarget.remove(0));
			else
			{
			queue.remove(0);
			queue.add(wordsOfTarget.get(i));
			}
			if(i>=size-1)
			{
				if(absoluteEnd.containsKey(queue.hashCode()))
					System.out.println("Plagerized from " + absoluteEnd.get(queue.hashCode())) ;
			}
		}
	}
}
