package ctci;

import java.util.HashSet;

public class RemoveDups	{
	public static void main(String [] args)	{

		/* LinkedListNode start = new LinkedListNode(12);
		start.setNext(new LinkedListNode(10));
			
		start.setNext(new LinkedListNode(11));	
		start.setNext(new LinkedListNode(12));
		start.setNext(new LinkedListNode(13));
		start.setNext(new LinkedListNode(15));
		start.setNext(new LinkedListNode(14));
		start.setNext(new LinkedListNode(15));	
		
		LinkedListNode.printList(start);
 
		LinkedListNode.printList(start); */

		LinkedList list = new LinkedList();
		
		list.add(12);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(15);
		list.add(14);
		list.add(15);

		list.printList();
		
		list.removeDuplicates();
		
		list.printList();
	}


	static void removeDups(LinkedListNode n)	{
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (n != null)	{
			if (set.contains(n.data))	{
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
}
