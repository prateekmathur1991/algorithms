package core;
// Prateek Mathur

// Java implementation of a queue
//
// Conditions for queue overflow and underflow
// Overflow: (rear + 1) MOD size == front
// Underflow: rear == front

// This queue implementation is broken, I need to fix this

import java.util.Arrays;

class Queue	{
	public int [] arr;
	
	// capacity represents the last index at which element can be enqueued.
	// So for a queue of at-most 5 elements, capacity would be 4, and size
	// would be 5
	public int capacity;
	public int front;
	public int rear;

	Queue(int size) {
		this.arr = new int[size];
		this.capacity = size - 1;
		this.front = this.rear = 0; 
	}

	public void enqueue(int num)	{
		if (rear + 1 % (capacity + 1) == front) {
			System.err.println("QUEUE OVERFLOW");
			return;
		}

		arr[rear] = num;
		if (rear == capacity) {
			rear = 0;
		} else {
			rear++;
		}		
	}

	public int dequeue()	{
		if (rear == front) {
			System.err.println("QUEUE UNDERFLOW");
			return Integer.MIN_VALUE;
		}

		int num = arr[front];
		if (front == capacity) {
			front = 0;
		} else {
			front++;
		}
		
		return num;
	}

	@Override
	public String toString()	{
		return Arrays.toString(this.arr);
	}
}
