package core;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

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

	public void add(T data) {

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
			}

			if (node.right != null) {
				nodesQueue.add(node.right);
			}
		}

		return searchNode;
	}

	public void delete(T data) {
		treeDelete(data);
	}

	private void treeDelete(T key) {

		if (root == null) {
			return;
		}

		// Find the deepest node
		// Find the node to be deleted
		// Replace node to be deleted's data with deepest's node data

		// Level order Traversal to find deepest node, and node to be searched
		Queue<Node> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);

		Node searchNode = null;
		Node deepestNode = null;

		while (!nodesQueue.isEmpty()) {

			deepestNode = nodesQueue.remove();

			if (deepestNode.data.equals(key)) {
				searchNode = deepestNode;
			}

			if (deepestNode.left != null) {
				nodesQueue.add(deepestNode.left);
			}

			if (deepestNode.right != null) {
				nodesQueue.add(deepestNode.right);
			}
		}

		if (searchNode == null) {
			return;
		}

		searchNode.data = deepestNode.data;

		// Delete deepest node
		nodesQueue.clear();

		nodesQueue.add(root);
		while (!nodesQueue.isEmpty()) {

			Node node = nodesQueue.remove();

			if (node.left != null) {

				if (node.left == deepestNode) {
					node.left = null;
					break;
				} else {
					nodesQueue.add(node.left);
				}
			}

			if (node.right != null) {
				if (node.right == deepestNode) {
					node.right = null;
					break;
				} else {
					nodesQueue.add(node.right);
				}
			}
		}
	}
	
	public void inOrder(Consumer<T> consumer) {
		treeInOrder(this.root, consumer);
	}

	private void treeInOrder(Node root, Consumer<T> consumer) {

		if (root != null) {
			treeInOrder(root.left, consumer);
			consumer.accept(root.data);
			treeInOrder(root.right, consumer);
		}
	}

	public void preOrder(Consumer<T> consumer) {
		treePreOrder(this.root, consumer);
	}

	private void treePreOrder(Node root, Consumer<T> consumer) {

		if (root != null) {
			consumer.accept(root.data);
			treePreOrder(root.left, consumer);
			treePreOrder(root.right, consumer);
		}
	}

	public void postOrder(Consumer<T> consumer) {
		treePostOrder(this.root, consumer);
	}

	private void treePostOrder(Node root, Consumer<T> consumer) {

		if (root != null) {
			treePostOrder(root.left, consumer);
			treePostOrder(root.right, consumer);
			consumer.accept(root.data);
		}
	}
}