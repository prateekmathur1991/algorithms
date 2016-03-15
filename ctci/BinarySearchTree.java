package ctci;
// Prateek Mathur

import java.util.ArrayList;
import java.util.LinkedList;

// A Java implementation of a Binary Search Tree

public class BinarySearchTree {
	// Inner class to represent a Node
	public class Node {
		public int key;
		public Node left;
		public Node right;
	
		Node()	{
			this.key = 0;
			left = right = null;
		}

		Node(int key)	{
			this.key = key;
			left = right = null;
		}

		@Override
		public String toString() {
			return Integer.toString(this.key);
		}
	}

	// Root of the BinarySearchTree
	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public String printRoot() {
		return this.root == null ? "EMPTY" : Integer.toString(this.root.key);
	}

	// Inserts a node in the BinarySearchTree
	public void insert(int key) {
		this.root = insertIntoBST(this.root, key);
	}

	private Node insertIntoBST(Node root, int key)	{
		if (null == root) {
			// No node present. Create a node and return it
			root = new Node(key);
			return root;
		}

		if (key <= root.key)	{
			root.left = insertIntoBST(root.left, key);
		} else {
			root.right = insertIntoBST(root.right, key);
		}

		// Return the root
		return root;
	}

	public void inorder()	{
		inorder(this.root);
	}
	
	private void inorder(Node root)	{
		if (null != root) {
			inorder(root.left);
			System.out.print(root.key + ", ");
			inorder(root.right);
		}
	}

	public String search(int key)	{
		Node getNode = searchNode(this.root, key);
		return getNode == null ? "Not Found" : getNode.toString();
	}

	private Node searchNode(Node root, int key)	{
		if (null == root || root.key == key) {
			return root;
		}

		if (key < root.key)	{
			return searchNode(root.left, key);	
		} else {
			return searchNode(root.right, key);
		}
	}

	public void delete(int key) {
		this.root = deleteKey(this.root, key);
	}

	private Node deleteKey(Node root, int key)	{
		if (null == root) {
			return root;
		}

		if (key < root.key)	{
			root.left = deleteKey(root.left, key);
		} else if (key > root.key) {
			root.right = deleteKey(root.right, key);
		} else {
			// This is the node to be deleted, as it has its
			// key equal to the root

			// If the node has only 1 child, return the other present chlid.
			// If the node has no children, null will be returned, which will destory the relation 
			// of this node with its parent, thereby deleting it from the tree
			if (null == root.left) {
				return root.right;
			} else if (null == root.right) {
				return root.left;
			}

			// A child with 2 elements
			// Find the inorder successor of this node, (which is the minimum value in the right
			// sub-tree), set this node to the min value, and delete the inorder successor
			root.key = minValue(root.right);
			root.right = deleteKey(root.right, root.key);  
		}

		return root;
	}

	private int minValue(Node root)	{
		int min = root.key;
		while (null != root.left) {
			min = root.left.key;
			root = root.left;
		}

		return min;
	}
	
	public ArrayList<LinkedList<Node>> listsAtLevel()	{
		return getListsAtLevel(this.root);
	}
	
	private ArrayList<LinkedList<Node>> getListsAtLevel(Node root)	{
		ArrayList<LinkedList<Node>> lists = new ArrayList<>();
		
		LinkedList<Node> current = new LinkedList<>();
		if (null != root)	{
			current.add(root);
		}
		
		while (current.size() > 0)	{
			lists.add(current);
			
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();
			
			for (Node parent : parents)	{
				if (null != parent.left)	{
					current.add(parent.left);
				}
				
				if (null != parent.right)	{
					current.add(parent.right);
				}
			}
		}
		
		return lists;
	}
}
