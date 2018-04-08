package core;

import java.util.Collection;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {

	private class Node<N> {

		private N data;

		private Node<N> parent;
		private Node<N> left;
		private Node<N> right;

		Node(N data) {
			this.data = data;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
	}

	private Node<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public Node<T> get(T data) {
		return treeSearch(this.root, data);
	}

	private Node<T> treeSearch(Node<T> root, T data) {

		if (root != null && root.data.equals(data)) {
			return root;
		}

		if (data.compareTo(root.data) <= 0) {
			return treeSearch(root.left, data);
		} else {
			return treeSearch(root.right, data);
		}
	}

	public void inOrder(Consumer<T> consumer) {
		treeInOrder(this.root, consumer);
	}

	private void treeInOrder(Node<T> root, Consumer<T> consumer) {

		if (root != null) {
			treeInOrder(root.left, consumer);
			consumer.accept(root.data);
			treeInOrder(root.right, consumer);
		}
	}

	public void preOrder(Consumer<T> consumer) {
		treePreOrder(this.root, consumer);
	}

	private void treePreOrder(Node<T> root, Consumer<T> consumer) {

		if (root != null) {
			consumer.accept(root.data);
			treeInOrder(root.left, consumer);
			treeInOrder(root.right, consumer);
		}
	}

	public void postOrder(Consumer<T> consumer) {
		treePostOrder(this.root, consumer);
	}

	private void treePostOrder(Node<T> root, Consumer<T> consumer) {

		if (root != null) {
			treeInOrder(root.left, consumer);
			treeInOrder(root.right, consumer);
			consumer.accept(root.data);
		}
	}

	public T minimum() {

		return treeMinimum(root).data;
	}

	private Node<T> treeMinimum(Node<T> root) {

		while (root.left != null) {
			root = root.left;
		}

		return root;
	}

	public T maximum() {

		return treeMaximum(root).data;
	}

	private Node<T> treeMaximum(Node<T> root) {

		while (root.right != null) {
			root = root.right;
		}

		return root;
	}

	public void add(T data) {

		treeInsert(root, new Node<>(data));
	}

	public void addAll(Collection<T> collection) {

		collection.forEach(data -> {
			treeInsert(root, new Node<>(data));
		});
	}

	public void addAll(T[] items) {

		for (T data : items) {
			treeInsert(root, new Node<>(data));
		}
	}

	private void treeInsert(Node<T> root, Node<T> z) {

		Node<T> y = null;
		Node<T> x = root;

		while (x != null) {

			y = x;
			if (z.data.compareTo(x.data) <= 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		z.parent = y;
		if (y == null) {
			this.root = z; // Tree was empty
		} else if (z.data.compareTo(y.data) <= 0) {
			y.left = z;
		} else {
			y.right = z;
		}
	}

	public T successor(T data) {

		Node<T> node = treeSearch(root, data);

		if (node == null) {
			return null;
		}

		return treeSuccessor(node).data;
	}

	private Node<T> treeSuccessor(Node<T> x) {

		if (x.right != null) {
			return treeMinimum(x.right);
		}

		Node<T> y = x.parent;
		while (y != null && x == y.right) {
			x = y;
			y = y.parent;
		}

		return y;
	}

	public T predecessor(T data) {

		Node<T> node = treeSearch(root, data);

		if (node == null) {
			return null;
		}

		return treePredecessor(node).data;
	}

	private Node<T> treePredecessor(Node<T> x) {

		if (x.left != null) {
			return treeMaximum(x.left);
		}

		Node<T> y = x.parent;
		while (y != null && x == y.left) {
			x = y;
			y = y.parent;
		}

		return y;
	}

	public void delete(T data) {

		Node<T> z = treeSearch(root, data);

		if (z == null) {
			return;
		}

		treeDelete(root, z);
	}

	private void treeDelete(Node<T> root, Node<T> z) {

		if (z.left == null) {
			transplant(root, z, z.right);
		} else if (z.right == null) {
			transplant(root, z, z.left);
		} else {

			Node<T> y = treeMinimum(z.right);
			if (y.parent != z) {
				transplant(root, y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}

			transplant(root, z, y);
			y.left = z.left;
			y.left.parent = y;
		}
	}

	private void transplant(Node<T> root, Node<T> u, Node<T> v) {

		if (u.parent == null) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}

		if (v != null) {
			v.parent = u.parent;
		}
	}

	public int getHeight() {

		return treeHeight(root);
	}

	private int treeHeight(Node<T> root) {

		if (root == null) {
			return 0;
		}

		return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
	}
}