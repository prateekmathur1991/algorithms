package ctci;
// Prateek Mathur

// Java code to test a Binary Search Tree

public class BTest	{
	public static void main(String [] args)	{
		BinarySearchTree tree = new BinarySearchTree();
		int [] nums = {10, 12, 78, 2, 33, 17, 45, 31};
		
		for (int num : nums)	{
			tree.insert(num);
		}

		System.out.println(tree.printRoot());

		tree.inorder();
		System.out.println();
		
		System.out.println(tree.search(10));
		System.out.println(tree.search(50));

		tree.delete(10);

		System.out.println(tree.printRoot());

		tree.inorder();
		System.out.println();	
	}
}
