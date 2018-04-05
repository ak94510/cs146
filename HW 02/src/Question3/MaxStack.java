package Question3;
import java.util.*;
public class MaxStack{
		private Stack<Integer> stack = new Stack<>();
		private Stack<Integer> maxValues = new Stack<>();
		public void push(int pushed)
		{
			stack.push(pushed);
			if(maxValues.size() ==0 ||pushed>maxValues.peek())
			{
				maxValues.push(pushed);
			}
		}
		public Integer pop()
		{
			if(stack.peek()==maxValues.peek())
			{
				stack.pop();
				return maxValues.pop();
			}
			else
				return stack.pop();
		}
		
		public int returnTheMax()
		{
			return maxValues.peek();
		}
		
		/*public static void main(String[] args)
		{
			MaxStack a = new MaxStack();
			a.push(1);
			a.push(5);
			a.push(3);
			System.out.println(a.returnTheMax());
			a.pop();
			System.out.println(a.returnTheMax());
			a.push(7);
			a.push(8);
			a.push(13);
			System.out.println(a.returnTheMax());
			a.push(2);
			a.push(5);
			System.out.println(a.returnTheMax());
			a.pop();
			a.pop();
			a.pop();
			a.pop();
			System.out.println(a.returnTheMax());
		}*/
}
