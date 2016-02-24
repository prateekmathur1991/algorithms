package ctci;

// import core.LinkedList;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class KthToLast {
	public static void main(String[] args) {
		core.LinkedList list = new core.LinkedList();
		Set<Integer> set = new HashSet<Integer>();
		
		Random rand = new Random();
		for (int i = 0; i < 10; i++)	{
			int num = rand.nextInt(100);
			if (set.add(num))	{
				list.add(num);
			}
		}

		list.printList();

		System.out.println(list.findKthToLast(3));
	}
}
