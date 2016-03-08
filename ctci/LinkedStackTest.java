package ctci;

import java.util.Random;

public class LinkedStackTest {

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();
		Random r = new Random();
		for (int i = 1; i <= 10; i++)	{
			stack.push(Integer.valueOf(r.nextInt()));
		}
		
		stack.push(Integer.valueOf(100));
		System.out.println(stack.isFull());
		System.out.println(stack.isEmpty());
		
		for (int i = 1; i <= 10; i++)	{
			System.out.println(stack.pop());
		}
		
		System.out.println(stack.isFull());
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.isFull());
		System.out.println(stack.isEmpty());
	}

}
