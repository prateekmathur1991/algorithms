package com.ds.core;

public class BinarySearchTree<T extends Comparable<T>> {
	
	// Inner class to represent a Node
	public class Node {
		
		public T key;
		public Node left;
		public Node right;

		Node(T key)	{
			this.key = key;
			left = right = null;
		}

		@Override
		public String toString() {
			return key == null ? "NULL" : key.toString();
		}
	}

	// Root of the BinarySearchTree
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public String printRoot() {
		return root == null ? "EMPTY" : root.toString();
	}

	// Inserts a node in the BinarySearchTree
	public void insert(T key) {
		this.root = insertIntoBST(root, key);
	}

	private Node insertIntoBST(Node root, T key)	{
		if (null == root) {
			// No node present. Create a node and return it
			root = new Node(key);
			return root;
		}

		if (key.compareTo(root.key) < 0)	{
			root.left = insertIntoBST(root.left, key);
		} else {
			root.right = insertIntoBST(root.right, key);
		}

		// Return the root
		return root;
	}

	public void inorder()	{
		inorder(root);
	}
	
	private void inorder(Node root)	{
		if (null != root) {
			inorder(root.left);
			System.out.print(root.key + ", ");
			inorder(root.right);
		}
	}

	public Node search(T key)	{
		return searchNode(this.root, key);
	}

	private Node searchNode(Node root, T key)	{
		if (null == root || root.key == key) {
			return root;
		}

		if (key.compareTo(root.key) == 0)	{
			return searchNode(root.left, key);	
		} else {
			return searchNode(root.right, key);
		}
	}

	public void delete(T key) {
		root = deleteKey(this.root, key);
	}

	private Node deleteKey(Node root, T key)	{
		if (null == root) {
			return root;
		}

		if (key.compareTo(root.key) < 0)	{
			root.left = deleteKey(root.left, key);
		} else if (key.compareTo(root.key) > 0) {
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

	private T minValue(Node root)	{
		T min = root.key;
		while (null != root.left) {
			min = root.left.key;
			root = root.left;
		}

		return min;
	}
}
