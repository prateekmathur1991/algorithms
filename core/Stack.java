package core;

public class Stack<T> {

	private T[] arr;
	private int top = -1;

	@SuppressWarnings("unchecked")
	public Stack() {
		arr = (T[]) new Object[10];
	}

	@SuppressWarnings("unchecked")
	public Stack(int size) {
		arr = (T[]) new Object[size];
	}

	public void push(T data) throws Exception {
		if (top == arr.length - 1) {
			throw new Exception("STACKOVERFLOW");
		}

		arr[++top] = data;
	}

	public T pop() throws Exception {
		if (top < 0) {
			throw new Exception("STACK UNDERFLOW");
		}

		return arr[top--];
	}

	public boolean isEmpty() {
		return top == -1;
	}
}