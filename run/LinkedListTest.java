package run;

import core.LinkedList;

public class LinkedListTest {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> linkedList = new LinkedList<>();

		linkedList.add(10);
		linkedList.add(15);
		linkedList.add(2);
		linkedList.add(20);
		linkedList.printList();
		
		linkedList.insertAfter(15, 3);
		linkedList.printList();

		linkedList.insertBefore(20, 5);
		linkedList.printList();

		linkedList.insertBefore(10, 9);
		linkedList.printList();
	}
}