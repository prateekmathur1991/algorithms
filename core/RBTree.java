package core;
// Prateek Mathur

// Java implementation of a Red Black Tree

public class RBTree	{
	// Inner class to represent a Node
	class Node	{
		public int num;
		public char color; // can be 'r' or 'b'
		public Node left;
		public Node right;
		public Node parent;

		Node()	{
			this.num = 0;
			this.left = this.right = this.parent = null;
			this.color = 'b';	
		}

		Node(int num, char color)	{
			if (color == 'r' || color == 'b')	{
				this.num = num;
				this.color = color;
				this.left = this.right = this.parent = null;	
			} else {
				System.err.println("Invalid color. Valid colors are 'r' or 'b'");
			}
		}
	}

	// Global Pointer to root
	Node root;

	public RBTree()	{
		this.root = null;
	}
}
