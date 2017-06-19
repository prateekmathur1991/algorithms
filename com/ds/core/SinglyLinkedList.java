package com.ds.core;

public class SinglyLinkedList<T> {

	// Inner class to represent a node
	class Node	{
		public T data;
		public Node next;

		Node(T num)	{
			this.data = num;
			this.next = null;
		}

		@Override
		public String toString()	{
			StringBuilder builder = new StringBuilder();
			builder.append(this.data);
			if (null != this.next) {
				builder.append("--->").append(this.next.data);
			}
			return builder.toString();
		}
	}

	// Global pointer to start
	Node start;

	public SinglyLinkedList()	{
		start = null;
	}

	public void add(T key) {
		Node node = new Node(key);

		if (null == start) {
			start = node;
			return;		
		}

		Node current = start;
		while (null != current.next) {
			current = current.next;
		}

		current.next = node;
	}

	public String search(T key)	{
		Node getNode = searchNode(key);
		return getNode == null ? "NOT FOUND" : getNode.toString();
	}

	private Node searchNode(T key)	{
		if (null == start) {
			return null;
		}

		Node current = start;
		while (null != current)	{
			if (key == current.data) {
				return current;
			}

			current = current.next;
		}

		return null;
	}

	public void insertAfter(T value, T key)	{
		if (null == start)	{
			System.err.println("LIST EMPTY");
			return;
		}		

		Node getNode = searchNode(value);
		if (getNode == null) {
			return;
		}

		Node node = new Node(key);
		
		Node temp = getNode.next;
		getNode.next = node;
		node.next = temp;
	}

	public void insertBefore(T value, T key)	{
		if (null == start)	{
			System.err.println("LIST EMPTY");
			return;
		}		

		this.start = insertRecordBefore(value, key);
	}

	private Node insertRecordBefore(T value, T key)	{
		Node node = new Node(key);

		if (value == this.start.data)	{
			Node temp = this.start;
			this.start = node;
			node.next = temp;
		} else	{
			Node current = start;
			Node prev = null;

			while (null != current.next && current.data != value)	{
				prev = current;
				current = current.next;
			}
		
			if (current.data == value)	{
				prev.next = node;
				node.next = current;
			}
		}

		return this.start;		
	}

	public void delete(T key)	{		
		if (null == start)	{
			System.err.println("LIST EMPTY");
			return;
		}
		
		this.start = deleteRecord(key);	
	}

	private Node deleteRecord(T key)	{
		if (key == this.start.data)	{
			start = start.next;
		} else {
			Node current = start;
			Node prev = null;
		
			while (null != current.next && current.data != key)	{
				prev = current;
				current = current.next;
			}

			
			if (current.data == key)	{
				prev.next = current.next;
				current = null;
			}
		}

		return this.start;
	}

	public void printList()	{
		if (null == start) {
			System.err.println("LIST EMPTY");
			return;
		}

		Node current = start;
		while (null != current)	{
			System.out.print(current.data.toString() + "--->");
			current = current.next;
		}
		
		System.out.println("END");
	}
	
	public void printRecursively()	{
		traverse(start);	
	}

	// Recursively traverses through the list and prints each element
	private void traverse(Node node)	{
		if (null == node.next)	{
			System.out.println(node.data.toString() + "--->END");
			return;
		} else {
			System.out.print(node.data.toString() + "--->");
			traverse(node.next);
		}
	}

	public T findMiddle()	{
		Node middle = findMiddle(this.start);
		return middle.data;
	}

	private Node findMiddle(Node start)	{		
		Node fastRunner = start;
		Node slowRunner = start;

		while (fastRunner.next != null)	{
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
		}

		return slowRunner;
	}
}
