package run;

import core.ArrayQueue;

public class QueueTest {

	public static void main(String[] args) {

		ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>(5);

		System.out.println("isFull():: " + integerArrayQueue.isFull());
		System.out.println("isEmpty():: " + integerArrayQueue.isEmpty());

		integerArrayQueue.enqueue(1);
		integerArrayQueue.enqueue(2);
		integerArrayQueue.enqueue(3);
		integerArrayQueue.enqueue(4);
		integerArrayQueue.enqueue(5);

		System.out.println("isFull():: " + integerArrayQueue.isFull());
		System.out.println("isEmpty():: " + integerArrayQueue.isEmpty());

		System.out.println(integerArrayQueue.dequeue());
		System.out.println(integerArrayQueue.dequeue());
		System.out.println(integerArrayQueue.dequeue());
		System.out.println(integerArrayQueue.dequeue());
		System.out.println(integerArrayQueue.dequeue());

		System.out.println("isFull():: " + integerArrayQueue.isFull());
		System.out.println("isEmpty():: " + integerArrayQueue.isEmpty());
	}
}