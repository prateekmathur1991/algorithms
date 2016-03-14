// Prateek Mathur

// Given a sorted integer array with unique elements, 
// construct a binary search tree with minimum height.

package ctci;

import java.util.Random;
import java.util.HashSet;
import java.util.Arrays;

public class MinBST	{
	public static void main(String [] args)	{
		BinarySearchTree tree = new BinarySearchTree();
		HashSet<Integer> set = new HashSet<Integer>();	// Needed for ensuring unique numbers
	
		Random r = new Random();
		int nums = 7;
		int [] arr = new int[nums];		

		for (int i = 0; i < nums; i++)	{
			int num = r.nextInt(20);
			if (num > 0 && !set.contains(num))	{
				arr[i] = num;	
			}
		}

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		createMinBST(tree, arr, 0, arr.length - 1);
		tree.inorder();
		
		System.out.println();
	}

	public static void createMinBST(BinarySearchTree tree, int [] arr, int low, int high)	{
		if (low == high)	{
			tree.insert(arr[low]);
			return;
		} else {
			int mid = high - ((high - low)/2);
			tree.insert(arr[mid]);

			createMinBST(tree, arr, low, mid - 1);
			createMinBST(tree, arr, mid + 1, high);
		}
	}
}
