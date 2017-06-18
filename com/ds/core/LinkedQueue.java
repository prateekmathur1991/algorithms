package com.ds.core;

public class LinkedQueue<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	private int size;
	private int MAX_NODES;

	{
		first = null;
		last = null;
	}

	public LinkedQueue()	{
		MAX_NODES = 10;
	}

	public LinkedQueue(int max)	{
		MAX_NODES = max;
	}

	public void add(T item) { 
		if (size == MAX_NODES)	{
			System.err.println("QUEUE FULL");
			return;
		}
		
		QueueNode<T> t = new QueueNode<T>(item);
		if (last != null) {
			last.next = t;
		}

		last = t;
		if (first == null) {
			first = last;
		}

		size++;
	} 

	public T remove() {
		if (first == null)	{
			System.err.println("QUEUE EMPTY");
			return null;
		}

		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}

		size--;
		return data;
	}
	
	public T peek() {
		if (first == null)	{
			System.err.println("QUEUE EMPTY");
			return null;
		}
		
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

	public boolean isFull()	{
		return size == MAX_NODES;
	}

	public int size()	{
		return size;
	}
}
