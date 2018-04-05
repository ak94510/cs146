package question5;
import java.util.*;
public class question5 {
	private Stack<Object> takeOffTop = new Stack<>();
	private Stack<Object> storage = new Stack<>();
	
	public void enqueue(Object a)
	{
		storage.push(a);
	}
	public Object dequeue()
	{
		if(takeOffTop.isEmpty())
		{
			while(!storage.isEmpty())
			{
				Object a = storage.pop();
				takeOffTop.push(a);
			}
		}
		return takeOffTop.pop();
	}
	/*public static void main(String[] args)
	{
		question5 a = new question5();
		a.enqueue("a");
		a.enqueue("b");
		a.enqueue("c");
		System.out.println((String)a.dequeue()+a.dequeue());
		a.enqueue("d");
		a.enqueue("e");
		a.enqueue("f");
		System.out.println((String)a.dequeue()+a.dequeue()+a.dequeue()+a.dequeue());
		
	}
	*/
}
