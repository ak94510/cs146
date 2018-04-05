package Question1;
import java.util.*;
import java.io.*;
public class Question1 {
	
	public ArrayList<Integer> readFile(String file) throws FileNotFoundException, IOException
	{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String number = "";
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i =0;i<line.length();i++)
		{
			String character = line.substring(i, i+1);
			if(character.equals(" ") || character.equals("."))
			{
				numbers.add(Integer.parseInt(number));
				number = "";
			}
			else
				number+=character;
		}
		br.close();
		fr.close();
		return numbers;
		
	}

}
