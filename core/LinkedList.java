package core;

import java.util.HashSet;

// Prateek Mathur

// Java implementation of a Singly Linked List

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

	public LinkedList()	{
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
		return getNode.num == Integer.MIN_VALUE ? "NOT FOUND" : getNode.toString();
	}

	private Node searchNode(int key)	{
		if (null == start) {
			return new Node(Integer.MIN_VALUE);
		}

		Node current = start;
		while (null != current)	{
			if (key == current.num) {
				return current;
			}

			current = current.next;
		}

		return new Node(Integer.MIN_VALUE);
	}

	public void insertAfter(int value, int key)	{
		if (null == start)	{
			System.err.println("LIST EMPTY");
			return;
		}		

		Node getNode = searchNode(value);
		if (getNode.num == Integer.MIN_VALUE) {
			return;
		}

		Node node = new Node(key);
		
		Node temp = getNode.next;
		getNode.next = node;
		node.next = temp;
	}

	public void insertBefore(int value, int key)	{
		if (null == start)	{
			System.err.println("LIST EMPTY");
			return;
		}		

		this.start = insertRecordBefore(value, key);
	}

	private Node insertRecordBefore(int value, int key)	{
		Node node = new Node(key);

		if (value == this.start.num)	{
			Node temp = this.start;
			this.start = node;
			node.next = temp;
		} else	{
			Node current = start;
			Node prev = null;

			while (null != current.next && current.num != value)	{
				prev = current;
				current = current.next;
			}
		
			if (current.num == value)	{
				prev.next = node;
				node.next = current;
			}
		}

		return this.start;		
	}

	public void delete(int key)	{		
		if (null == start)	{
			System.err.println("LIST EMPTY");
			return;
		}
		
		this.start = deleteRecord(key);	
	}

	private Node deleteRecord(int key)	{
		if (key == this.start.num)	{
			start = start.next;
		} else {
			Node current = start;
			Node prev = null;
		
			while (null != current.next && current.num != key)	{
				prev = current;
				current = current.next;
			}

			
			if (current.num == key)	{
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
			System.out.print(Integer.toString(current.num) + "--->");
			current = current.next;
		}
		
		System.out.println("END");
	}
	
	public void removeDuplicates()	{
		removeDups(start);
		
		/* int [] arr = new int[Integer.MAX_VALUE];
		Node current = start.next;
		Node prev = current;
		
		while (null != current)	{
			arr[current.num]++;
			if (arr[current.num] >= 2)	{
				prev.next = current.next;
				current = current.next;
			} else {
				prev = current;
				current = current.next;
			}
		} */
	}
	
	private void removeDups(Node node)	{
		HashSet<Integer> set = new HashSet<Integer>();
		Node prev = null;
		
		while (null != node)	{
			if (set.contains(node.num))	{
				prev.next = node.next;
			} else {
				set.add(node.num);
				prev = node;
			}
			
			node = node.next;
		}
	}	

	public int findKthToLast(int k)	{
		Node n = kthToLast(start, k);
		return n == null ? Integer.MIN_VALUE : n.num;
	}

	private Node kthToLast(Node start, int k)	{
		Node p1 = start;
		Node p2 = start;

		for (int i = 0; i < k; i++)	{
			if (null == p1)	{
				return null;
			}

			p1 = p1.next;
		}

		while (null != p1)	{
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}

	public void printRecursively()	{
		traverse(start);	
	}

	// Recursively traverses through the list and prints each element
	private void traverse(Node node)	{
		if (null == node.next)	{
			System.out.println(Integer.toString(node.num) + "--->END");
			return;
		} else {
			System.out.print(Integer.toString(node.num) + "--->");
			traverse(node.next);
		}
	}
}
