package ctci;

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
	public Node start;

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
	
	// Methods for problems from Cracking The Coding Interview start here
	public void removeDuplicates()	{
		removeDups(start);
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

	public boolean isPalindrome()	{
		return isPalindrome(start);
	}

	private boolean isPalindrome(Node start)	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>(100);
		Node p1 = start; // Fast runner
		Node p2 = start; // Slow runner

		while (p1 != null && p1.next != null)	{
			stack.push(p2.num);
			p1 = p1.next.next;
			p2 = p2.next;
		}

		if (p1 != null)	{
			p2 = p2.next;
		}

		while (p2 != null)	{
			int top = stack.pop().intValue();
			if (top != p2.num)	{
				return false;
			}
			p2 = p2.next;
		}	
		
		return true;	
	} 

	// Computes the sum of 2 numbers saved in inverted form in a Linked List
	public static LinkedList computeInvertedSum(LinkedList list1, LinkedList list2)	{
		LinkedList iSum = new LinkedList();
		computeInvertedSum(list1.start, list2.start, 0, iSum);
		return iSum;
	}
	
	private static void computeInvertedSum(Node node1, Node node2, int carry, LinkedList iSum)	{
		if (node1 != null && node2 != null)	{
			int sum = node1.num + node2.num + carry;
			if (sum >= 10)	{
				iSum.add(sum%10);
			} else {
				iSum.add(sum);
			}
			
			computeInvertedSum(node1.next, node2.next, sum/10, iSum);
		} else {
			if (node2 == null)	{
				if (node1 != null) {
					iSum.add(node1.num + carry);
				}
			} else {
				iSum.add(node2.num + carry);
			}
		}
	}
}
