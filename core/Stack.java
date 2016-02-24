package core;
// Prateek Mathur

// Java implementation of a Stack

public class Stack	{
	private int top;
	private int [] stack;

	Stack() {
		this.top = -1;
		stack = new int [10];	
	}

	Stack(int size)	{
		this.top = -1;
		stack = new int [size];
	}

	public void push(int num) {
		if (this.top == stack.length - 1) {
			System.err.println("STACK OVERFLOW");
			return;
		}

		stack[++this.top] = num;
	}

	public int pop() {
		if (this.top == - 1) {
			System.err.println("STACK UNDERFLOW");
			return -1;
		}

		return stack[this.top--];
	}

	public void printStack()	{
		int i = this.top;
		while (i != -1) {
			System.out.print(stack[i--] + ", ");
		}
	}
}
