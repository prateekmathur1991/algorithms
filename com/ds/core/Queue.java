package com.ds.core;

public class Queue<T> {
	
	private T [] arr;
	
	private int max = 5;
	
	private int head = -1;
	
	private int tail = 0;
	
	@SuppressWarnings("unchecked")
	public Queue() {
		arr = (T []) new Object[max];
	}

	@SuppressWarnings("unchecked")
	public Queue(int max) {
		this.max = max;
		arr = (T []) new Object[max];
	}

	public boolean isFull() {
		return head == tail;
	}

	public boolean isEmpty() {
		return head == -1;
	}

	public void enqueue(T obj) throws Exception {
		
		if (isFull()) {
			throw new Exception("Queue is full");
		}
		
		arr[tail] = obj;
		
		if (head == -1) {
			head = tail;
		}
		
		tail = (tail + 1) % max;
	}

	public T dequeue() throws Exception {
		
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		
		T obj = arr[head];
		head = (head + 1) % max;
		
		if (head == tail) {
			head = -1;
		}

		return obj;
	}
}
