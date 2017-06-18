package com.ds.core;

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
	
	public void push(T obj) {
		if (this.isFull()) {
			throw new RuntimeException("Stack is full");
		}
		
		this.top = this.top + 1;
		this.arr[top] = obj;
	}
	
	public T pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		
		T obj = this.arr[this.top];
		this.top = this.top - 1;
		
		return obj;
	}
}