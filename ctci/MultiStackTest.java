package ctci;

public class MultiStackTest	{
	public static void main(String [] args) throws Exception	{
		MultiStack multiStack = new MultiStack(3);
		multiStack.push(1, 10);
		multiStack.push(2, 30);
		multiStack.push(1, 22);
		multiStack.push(1, 1);

		multiStack.push(1, 3);

		System.out.println(multiStack.pop(1));
		System.out.println(multiStack.pop(2));
		
	}
}
