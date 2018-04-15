package core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree<T> {

	private static final class Node<N> {

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

	public BinaryTree() {
		this.root = null;
	}

	public boolean contains(T data) {
		return treeSearch(this.root, data) != null;
	}

	private Node<T> treeSearch(Node<T> root, T data) {

		// TODO
		return null;
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
			treePreOrder(root.left, consumer);
			treePreOrder(root.right, consumer);
		}
	}

	public void postOrder(Consumer<T> consumer) {
		treePostOrder(this.root, consumer);
	}

	private void treePostOrder(Node<T> root, Consumer<T> consumer) {

		if (root != null) {
			treePostOrder(root.left, consumer);
			treePostOrder(root.right, consumer);
			consumer.accept(root.data);
		}
	}

	public void add(T data) {

		treeInsert(root, new Node<>(data));
	}

	public void addAll(Collection<T> collection) {

		collection.forEach(data -> treeInsert(root, new Node<>(data)));
	}

	public void addAll(T[] items) {

		for (T data : items) {
			treeInsert(root, new Node<>(data));
		}
	}

	private void treeInsert(Node<T> root, Node<T> z) {

		if (root == null) {
			this.root = z;
			return;
		}

		Node<T> temp = root;

		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(temp);

		while (!queue.isEmpty()) {

			temp = queue.remove();

			if (temp.left == null) {
				temp.left = z;
				z.parent = temp;
				break;
			} else {
				queue.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = z;
				z.parent = temp;
				break;
			} else {
				queue.add(temp.right);
			}
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

		// TODO
		return null;
	}

	public T predecessor(T data) {

		Node<T> node = treeSearch(root, data);

		if (node == null) {
			return null;
		}

		return treePredecessor(node).data;
	}

	private Node<T> treePredecessor(Node<T> x) {

		// TODO
		return null;
	}

	public void delete(T data) {

		Node<T> z = treeSearch(root, data);

		if (z == null) {
			return;
		}

		treeDelete(root, z);
	}

	private void treeDelete(Node<T> root, Node<T> z) {

		// TODO
	}

	@SuppressWarnings("unused")
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