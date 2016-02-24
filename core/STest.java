package core;
// Prateek Mathur

// Java program to test a stack

public class STest	{
	public static void main(String [] args)	{
		int [] nums = {10, 23, 21, 67, 1, 89, 3};
		Stack stack = new Stack(nums.length);

		for (int num : nums) {
			stack.push(num);
		}

		stack.printStack();
		System.out.println();

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		stack.printStack();
		System.out.println();
	}
}
