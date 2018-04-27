package core;

import java.util.LinkedList;
import java.util.Queue;

// Binary Tree

// Should support - Insertion, Deletion, Traversal

public class BinaryTree<T> {

	private final class Node {

		private T data;
		private Node left;
		private Node right;

		Node(T data) {
			this.data = data;
		}
	}

	private Node root;

	public void insert(T data) {

		if (root == null) {
			root = new Node(data);
			return;
		}

		treeInsert(root, new Node(data));
	}

	private void treeInsert(Node root, Node newNode) {

		// Level Order Traversal
		Queue<Node> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);

		while (!nodesQueue.isEmpty()) {

			Node node = nodesQueue.remove();

			if (node.left != null) {
				nodesQueue.add(node.left);
			} else {
				node.left = newNode;
				break;
			}

			if (node.right != null) {
				nodesQueue.add(node.right);
			} else {
				node.right = newNode;
				break;
			}
		}
	}

	public boolean contains(T data) {
		return treeSearch(data) != null;
	}

	private Node treeSearch(T data) {

		if (root == null) {
			return null;
		}
		
		if (data == null) {
			throw new NullPointerException();
		}

		// Level Order Traversal
		Queue<Node> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);
		
		Node searchNode = null;

		while (!nodesQueue.isEmpty()) {

			Node node = nodesQueue.remove();
			if (node.data.equals(data)) {
				searchNode = node;
			}

			if (node.left != null) {
				nodesQueue.add(node.left);
			} else {
				break;
			}

			if (node.right != null) {
				nodesQueue.add(node.right);
			} else {
				break;
			}
		}
		
		return searchNode;	
	}
	
	public void delete(T data) {
		treeDelete(data);
	}
	
	private void treeDelete(T data) {
		
		if (root == null) {
			return;
		}
		
		// Find the deepest node
		// Find the node to be deleted
		// Replace node to be deleted's data with deepest's node data
		
		
	}
}