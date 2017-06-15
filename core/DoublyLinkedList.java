package core;

// A doubly linked list implementation using a sentinel

public class DoublyLinkedList<T> {
	
	private class Node {
		
		private T item;
		
		private Node previous;
		
		private Node next;
		
		Node(T item) {
			this.item = item;
		}

		T getItem() {
			return item;
		}
		
		void setPrevious(Node previous) {
			this.previous = previous;
		}
		
		Node getPrevious() {
			return previous;
		}
		
		void setNext(Node next) {
			this.next = next;
		}
		
		Node getNext() {
			return next;
		}
	}
	
	@SuppressWarnings("unchecked")	// Since we know that object can be type-casted to T
	private final Node SENTINEL = new Node((T) new Object());
	
	public DoublyLinkedList() {
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
	}
	
	public void add(T obj) {
		
		Node node = new Node(obj);
		
		node.setNext(SENTINEL.getNext());
		SENTINEL.getNext().setPrevious(node);
		SENTINEL.setNext(node);
		node.setPrevious(SENTINEL);
	}
	
	public String printList() {
		
		StringBuilder builder = new StringBuilder();
		
		Node current = SENTINEL.getNext();
		while (current != SENTINEL) {
			builder.append(current.getItem()).append("->");
			current = current.getNext();
		}
		
		builder.append("END");
		
		return builder.toString();
	}
}