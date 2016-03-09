// Prateek Mathur

// This program sorts a stack using an auxillary stack

package ctci;

public class SortStack	{
	public static void main(String [] args)	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>();

		stack.push(-20);
		stack.push(10);
		stack.push(2);
		stack.push(45);
		stack.push(12);

		System.out.println(stack);
		
		sortStack(stack);

		System.out.println(stack);
	}

	public static void sortStack(LinkedStack<Integer> stack)	{
		LinkedStack<Integer> secondary = new LinkedStack<Integer>();
		while (!stack.isEmpty())	{
			int temp = stack.pop();
			while (!secondary.isEmpty() && secondary.peek() > temp)	{
				stack.push(secondary.pop());
			}

			secondary.push(temp);
		}

		while (!secondary.isEmpty())	{
			stack.push(secondary.pop());
		}
	}
}
