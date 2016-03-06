// Prateek Mathur

// A Stack that supports the additional capability of 
// returing the minimum element currently present in the stack.
// The operations push(), pop() and min() all run in O(1) time.

package ctci;

import java.util.Arrays;

public class MinStack	{
	// An additional class is required to track the
	// minimum element every time a push() or pop() operation
	// is called.
	public class StackNode	{
		public int data;
		public int min;

		public StackNode(int data, int min)	{
			this.data = data;
			this.min = min;
		}

		public int getMin()	{
			return min;
		}

		@Override
		public String toString()	{
			return Integer.toString(data);
		}
	}	

	public int min = Integer.MAX_VALUE;
	public StackNode[] stack;
	public int size;
	public int top = -1;

	public MinStack(int size)	{
		stack = new StackNode[size];
		this.size = size;
	}

	public boolean isFull()	{
		return top == (size - 1);	
	}

	public boolean isEmpty()	{
		return top == -1;
	}

	public void push(int data) throws Exception	{
		if (isFull()) {
			throw new Exception("STACK OVERFLOW");
		}
		
		int newMin = Math.min(data, min());
		StackNode node = new StackNode(data, newMin);
		
		top++;
		stack[top] = node;
	}

	public int pop() throws Exception	{
		if (isEmpty())	{
			throw new Exception("STACK UNDERFLOW");
		}

		StackNode node = stack[top];
		stack[top] = null;
		top--;
			
		return node.data;
	}

	public int min() throws Exception	{
		if (isEmpty())	{
			return Integer.MAX_VALUE;
		} else {
			return peekNode().min;
		}
	}
	
	public int peek() throws Exception	{
		if (isEmpty())	{
			throw new Exception("STACK UNDERFLOW");
		}

		System.out.println("Top at which peek:: " + top);
		StackNode node = stack[top];
		
		return node.data;
	}
	
	private StackNode peekNode() throws Exception	{
		if (isEmpty())	{
			throw new Exception("STACK UNDERFLOW");
		}
		
		return stack[top];
	}

	@Override
	public String toString()	{
		return Arrays.toString(this.stack);
	}
}
