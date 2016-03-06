package ctci;

public class MinStackTest	{
	public static void main(String [] args) throws Exception	{
		MinStack minStack = new MinStack(8);

		minStack.push(10);
		minStack.push(20);
		minStack.push(5);
		minStack.push(12);
		minStack.push(2);
	
		System.out.println(minStack);
	
		System.out.println("Min:: " + minStack.min());

		minStack.pop();

		System.out.println("Min:: " + minStack.min());
	}
}
