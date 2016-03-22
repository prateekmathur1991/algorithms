package ctci;
// Prateek Mathur

// A Java implementation of a Binary Tree

public class BinaryTree {
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

	// Root of the BinaryTree
	private Node root;

	BinaryTree() {
		this.root = null;
	}

	public String printRoot() {
		return this.root == null ? "EMPTY" : Integer.toString(this.root.key);
	}

	// Inserts a node in the BinaryTree
	public void insert(int key) {
		this.root = insertIntoBST(this.root, key);
	}

	private Node insertIntoBST(Node root, int key)	{
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
	
	public void preorder()	{
		preorder(this.root);
	}
	
	public void postorder()	{
		postorder(this.root);
	}
	
	private void inorder(Node root)	{
		if (null != root) {
			inorder(root.left);
			System.out.print(root.key + ", ");
			inorder(root.right);
		}
	}
	
	private void preorder(Node root)	{
		if (null != root)	{
			System.out.print(root.key + ", ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	private void postorder(Node root)	{
		if (null != root)	{
			preorder(root.left);
			preorder(root.right);
			System.out.print(root.key + ", ");
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

		Node result = null;
		if (null != root.left)	{
			result = searchNode(root.left, key);
		}
		
		if (null == result) {
			result = searchNode(root.right, key);
		}
		
		return result;
	}

	public void delete(int key) {
		this.root = deleteKey(this.root, key);
	}

	private Node deleteKey(Node root, int key)	{
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
	
	// This method's definition of a balanced tree is - a tree is balanced
	// if height of both subtrees of every node do not differ by more than 1
	public boolean isBalanced()	{
		return isBalanced(this.root);
	}

	private boolean isBalanced(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	private int checkHeight(Node root)	{
		if (null == root) {
			return -1;
		}
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)	{
			return Integer.MIN_VALUE;
		}
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)	{
			return Integer.MIN_VALUE;
		}
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1)	{
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public boolean isBinarySearchTree()	{
		return isBinarySearchTree(this.root);
	}

	private boolean isBinarySearchTree(Node root) {
		boolean result = true;
		if (null != root.left)	{
			if (root.left.key > root.key)	{
				result = false;
			} else {
				result = isBinarySearchTree(root.left);
			}
		}	
		
		if (result) {
			if (null != root.right) {
				if (root.right.key <= root.key) {
					result = false;
				} else {
					result = isBinarySearchTree(root.right);
				}
			}
		}
		
		return result;
	}
}
