package core;

public class LinkedList<T> {
	
	private static final class Node<T> {
		
		private T data;
		private Node<T> next;

		Node(T num) {
			this.data = num;
			this.next = null;
		}
	}

	// Global pointer to start
	Node<T> start;

	public LinkedList() {
		start = null;
	}

	public void add(T key) {
		Node<T> node = new Node<>(key);

		if (null == start) {
			start = node;
			return;
		}

		Node<T> current = start;
		while (null != current.next) {
			current = current.next;
		}

		current.next = node;
	}
	
	public boolean contains(T key) {
		return searchNode(key) != null;
	}

	private Node<T> searchNode(T key) {
		if (null == start) {
			throw new RuntimeException("LIST EMPTY");
		}

		Node<T> current = start;
		while (null != current) {
			if (key.equals(current.data)) {
				return current;
			}

			current = current.next;
		}

		return null;
	}

	public void insertAfter(T value, T key) {
		if (null == start) {
			throw new RuntimeException("LIST EMPTY");
		}

		Node<T> getNode = searchNode(value);
		if (getNode == null) {
			return;
		}

		Node<T> node = new Node<>(key);

		Node<T> temp = getNode.next;
		getNode.next = node;
		node.next = temp;
	}

	public void insertBefore(T value, T key) {
		if (null == start) {
			throw new RuntimeException("LIST EMPTY");
		}

		this.start = insertRecordBefore(value, key);
	}

	private Node<T> insertRecordBefore(T value, T key) {
		
		Node<T> node = new Node<>(key);

		if (value.equals(this.start.data)) {
			Node<T> temp = this.start;
			this.start = node;
			node.next = temp;
		} else {
			Node<T> current = start;
			Node<T> prev = null;

			while (null != current.next && !current.data.equals(value)) {
				prev = current;
				current = current.next;
			}

			if (current.data.equals(value)) {
				prev.next = node;
				node.next = current;
			}
		}

		return this.start;
	}

	public void delete(T key) {
		
		if (null == start) {
			throw new RuntimeException("LIST EMPTY");
		}

		this.start = deleteRecord(key);
	}

	private Node<T> deleteRecord(T key) {
		
		if (key.equals(this.start.data)) {
			start = start.next;
		} else {
			Node<T> current = start;
			Node<T> prev = null;

			while (null != current.next && !current.data.equals(key)) {
				prev = current;
				current = current.next;
			}

			if (current.data.equals(key)) {
				prev.next = current.next;
				current = null;
			}
		}

		return this.start;
	}

	public void printList() {
		
		if (null == start) {
			throw new RuntimeException("LIST EMPTY");
		}

		Node<T> current = start;
		while (null != current) {
			System.out.print(String.valueOf(current.data) + "--->");
			current = current.next;
		}

		System.out.println("END");
	}

	public void printRecursively() {
		traverse(start);
	}

	// Recursively traverses through the list and prints each element
	private void traverse(Node<T> node) {
		if (null == node.next) {
			System.out.println(String.valueOf(node.data) + "--->END");
			return;
		} else {
			System.out.print(String.valueOf(node.data) + "--->");
			traverse(node.next);
		}
	}

	public T findMiddle() {
		Node<T> middle = findMiddle(this.start);
		return middle.data;
	}

	private Node<T> findMiddle(Node<T> start) {
		Node<T> fastRunner = start;
		Node<T> slowRunner = start;

		while (fastRunner.next != null) {
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
		}

		return slowRunner;
	}
}