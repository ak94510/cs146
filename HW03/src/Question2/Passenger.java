package Question2;
import java.util.*;
public class Passenger{
	public int level;
	public String name;
	public int code;
	
	public Passenger(String name, int level)
	{
		this.level = level;
		Random gen = new Random();
		code = gen.nextInt(Integer.MAX_VALUE);
		this.name = name;
	}
	public Passenger(String name, int level, int code)
	{
		this.level = level;
		this.code = code;
		this.name = name;
	}
	public boolean equals(Object that)
	{
		Passenger thatPass = (Passenger)that;
		if(this.code==thatPass.code && this.name.toLowerCase().equals(thatPass.name.toLowerCase())&&this.level == thatPass.level)
			return true;
		return false;
	}
	
	public int hashCode()
	{
		return code;
	}
}
