package ctci;

public class LinkedStack<T>	{
	private static class StackNode<T>	{
		private T data;
		private StackNode<T> next;

		public StackNode(T d)	{
			this.data = d;
		}
	}

	private StackNode<T> top;
	private int size;
	private static int MAX_NODES = 10;

	{
		size = 0;
		top = null;
	}

	public T pop()	{
		if (top == null) {
			System.err.println("STACK UNDERFLOW");
			return null;
		}

		T item = top.data;
		top = top.next;
		size--;
		return item;
	}

	public void push(T item)	{
		if (size == MAX_NODES) {
			System.err.println("STACK OVERFLOW");
			return;
		}

		StackNode<T> node = new StackNode<T>(item);
		node.next = top;
		top = node;
		size++;
	}

	public T peek()	{
		if (top == null) {		
			System.err.println("STACK UNDERFLOW");
			return null;
		}

		T item = top.data;
		return item;
	}

	public boolean isEmpty()	{
		return top == null;
	}

	public boolean isFull()	{
		return size == MAX_NODES;
	}

	public int size()	{
		return size;
	}
}
