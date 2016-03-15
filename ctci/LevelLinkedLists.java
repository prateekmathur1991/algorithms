// Prateek Mathur

// Create Linked Lists for all levels

package ctci;

import java.util.ArrayList;
import java.util.LinkedList;

import ctci.BinarySearchTree.Node;

public class LevelLinkedLists	{
	public static void main(String [] args)	{
		// Although this problem requires a Binary Tree, I am using a
		// Binary Search Tree as I don't have a Binary Tree implementation 
		// ready
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10);
		bst.insert(20);
		bst.insert(2);
		bst.insert(146);
		bst.insert(456);
		bst.insert(45);
		bst.insert(47);
		
		ArrayList<LinkedList<Node>> lists = bst.listsAtLevel();
		System.out.println(lists);
	}
}
