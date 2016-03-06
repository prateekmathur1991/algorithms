package ctci;

public class CheckListPalin	{
	public static void main(String [] args)	{
		LinkedList list = new LinkedList();
		
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(0);

		System.out.println(list.isPalindrome());
	}
}
