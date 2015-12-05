// Prateek Mathur

// Java implementation of a Singly Linked List

// TODO
// Operations to be supported
// 1. Insert Before Node
// 2. Insert After Node
// 3. Delete Node

public class LinkedList	{
	// Inner class to represent a node
	class Node	{
		public int num;
		public Node next;

		Node()	{
			this.num = 0;
			this.next = null;
		}

		Node(int num)	{
			this.num = num;
			this.next = null;
		}

		@Override
		public String toString()	{
			StringBuilder builder = new StringBuilder();
			builder.append(this.num);
			if (null != this.next) {
				builder.append("--->").append(this.next.num);
			}
			return builder.toString();
		}
	}

	// Global pointer to start
	Node start;

	LinkedList()	{
		start = null;
	}

	public void add(int key) {
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

	public String search(int key)	{
		Node getNode = searchNode(key);
		return getNode.toString();
	}

	private Node searchNode(int key)	{
		if (null == start) {
			return new Node(Integer.MIN_VALUE);
		}

		Node current = start;
		while (null != current.next)	{
			if (key == current.num) {
				return current;
			}

			current = current.next;
		}

		return new Node(Integer.MIN_VALUE);
	}

	public void insertAfter(int value, int key)	{
		Node getNode = search(value);
		if (getNode.num == Integer.MIN_VALUE) {
			return;
		}

		Node node = new Node(key);
		
		Node temp = getNode.next;
		getNode.next = node;
		node.next = temp;
	}

	public void insertBefore(int value, int key)	{
		Node getNode = search(value);
		if (getNode.num == Integer.MIN_VALUE) {
			return;
		}

		Node node = new Node(key);
		Node current = start;
		while (null != current.next || current.num != value) {
			current = current.next;
		}
		
			
	}

	public void delete(int key)	{

	}

	public void printList()	{
		if (null == start) {
			System.err.println("LIST EMPTY");
			return;
		}

		Node current = start;
		while (null != current.next)	{
			System.out.print(Integer.toString(current.num) + "--->");
			current = current.next;
		}
		
		System.out.println("END");
	}
}
