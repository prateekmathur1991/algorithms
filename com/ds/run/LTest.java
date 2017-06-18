package com.ds.run;

import com.ds.core.SinglyLinkedList;

public class LTest	{
	
	public static void main(String [] args)	{
		
		SinglyLinkedList linkedList = new SinglyLinkedList();
		
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

		System.out.println(linkedList.findMiddle());
	
		/* System.out.println(linkedList.search(20));
		System.out.println(linkedList.search(15));

		linkedList.delete(9);
		linkedList.printList();

		linkedList.delete(9);
		linkedList.printList(); */
	}
}
