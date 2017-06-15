package core;

import com.practice.exception.StackEmptyException;
import com.practice.exception.StackFullException;

public class Stack<T> {
	
	private T [] arr;
	
	private int max = 5;
	
	private int top = -1;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		this.arr = (T []) new Object[this.max];
	}
	
	@SuppressWarnings("unchecked")
	public Stack(int max) {
		this.max = max;
		this.arr = (T []) new Object[this.max];
	}
	
	public boolean isFull() {
		return top == (max - 1);
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(T obj) throws StackFullException {
		if (this.isFull()) {
			throw new StackFullException("Stack is full");
		}
		
		this.top = this.top + 1;
		this.arr[top] = obj;
	}
	
	public T pop() throws StackEmptyException {
		if (this.isEmpty()) {
			throw new StackEmptyException("Stack is empty");
		}
		
		T obj = this.arr[this.top];
		this.top = this.top - 1;
		
		return obj;
	}
}