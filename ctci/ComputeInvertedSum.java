package ctci;

public class ComputeInvertedSum {
	public static void main(String [] args)	{
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.add(7);
		list1.add(1);
		list1.add(6);
		
		list2.add(5);
		list2.add(9);
		list2.add(2);
		list2.add(3);
		
		LinkedList iSum = LinkedList.computeInvertedSum(list1, list2);
		
		iSum.printList();
	}
}
