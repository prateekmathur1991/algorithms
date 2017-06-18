package com.ds.core;

public class LinkedStack<T>	{
	private static class StackNode<T>	{
		private T data;
		private StackNode<T> next;

		public StackNode(T d)	{
			this.data = d;
		}

		public T getData()	{
			return data;
		}
	}

	private StackNode<T> top;
	private int size;
	private int MAX_NODES;

	{
		top = null;
	}

	public LinkedStack()	{
		MAX_NODES = 10;
	}

	public LinkedStack(int max)	{
		MAX_NODES = max;
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

	@Override
	public String toString()	{
		StackNode<T> start = top;
		if (start == null)	{
			return "";
		}

		StringBuilder builder = new StringBuilder();
		while (start.next != null)	{
			builder.append(start.getData()).append("-->");
			start = start.next;
		}
		builder.append("END");

		return builder.toString();
	}
}
