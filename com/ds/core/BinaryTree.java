package com.ds.core;

public class BinaryTree<T extends Comparable<T>> {
	
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

	// Root of the BinaryTree
	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public String printRoot() {
		return this.root == null ? "EMPTY" : root.key.toString();
	}

	// Inserts a node in the BinaryTree
	public void insert(T key) {
		this.root = insertIntoBST(this.root, key);
	}

	private Node insertIntoBST(Node root, T key)	{
		if (null == root) {
			// No node present. Create a node and return it
			root = new Node(key);
			return root;
		}

		if (null == root.left)	{
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

	public String search(T key)	{
		Node getNode = searchNode(this.root, key);
		return getNode == null ? "Not Found" : getNode.toString();
	}

	private Node searchNode(Node root, T key)	{
		if (null == root || root.key == key) {
			return root;
		}

		Node result = null;
		if (null != root.left)	{
			result = searchNode(root.left, key);
		}
		
		if (null == result) {
			result = searchNode(root.right, key);
		}
		
		return result;
	}

	public void delete(T key) {
		this.root = deleteKey(this.root, key);
	}

	private Node deleteKey(Node root, T key)	{
		if (root.key == key) {
			if (root.left == null) {
				root = root.right;
			} else {
				Node temp = root.left;
				while (null != temp.right)	{
					temp = temp.right;
				}
				
				root.key = temp.key;
				root.left = deleteKey(root.left, root.key);
			}
			
		} else if (searchNode(root.left, key) != null)	{
			root.left = deleteKey(root.left, key);
		} else {
			root.right = deleteKey(root.right, key);
		}
		
		return root;
	}
}