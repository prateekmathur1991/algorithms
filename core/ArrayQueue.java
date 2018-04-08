package core;

/**
 * Implementation of Queue data structure using an underlying array. This
 * implementation is circular in nature, and "wraps around" the rear and front
 * pointers in the sense that index 0 immediately follows index (size - 1).
 */
public class ArrayQueue<T> {

	private T[] data;
	private int front;
	private int rear;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		data = (T[]) new Object[size];
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {
		return front == -1 && rear == 1;
	}

	public boolean isFull() {
		return (front == 0 && rear == data.length - 1) || (front == rear + 1);
	}

	public void enqueue(T obj) {

		if (isFull()) {
			throw new RuntimeException("QUEUE FULL");
		}

		if (front == -1) {
			// First element
			front = rear = 0;
		} else if (rear == data.length - 1 && front != 0) {
			// Wrap Around
			rear = 0;
		} else {
			rear++;
		}

		data[rear] = obj;
	}

	public T dequeue() {

		if (isEmpty()) {
			throw new RuntimeException("QUEUE EMPTY");
		}

		T t = data[front];

		if (front == rear) {
			// Empty the queue
			front = rear = -1;
		} else if (front == data.length - 1) {
			// Wrap Around
			front = 0;
		} else {
			front++;
		}

		return t;
	}
}