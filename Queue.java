// Prateek Mathur

// Java program to implement a Queue

public class Queue	{
	public int [] queue;
	public int front;
	public int rear;

	Queue(int size)	{
		queue = new int[size];
		front = rear = 0;
	}

	public void enqueue(int num) {
		if (rear == queue.length - 1) {
			System.err.println("QUEUE FULL");
			return;
		}

		queue[rear] = num;
		rear++;
	}

	public int dequeue()	{
		if (front == rear) {
			System.out.println("QUEUE EMPTY");
			return -1;
		}

		int num = queue[front];
		front++;
		return num;
	}

	public void printQueue() {
		int i = front;
		while (i++ != rear)	{
			System.out.print(queue[i] + ", ");
		}		
	}	
}
