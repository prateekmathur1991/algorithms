package ctci;

import core.LinkedList;

public class RemoveDups	{
	public static void main(String [] args)	{

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
}
