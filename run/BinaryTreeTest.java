package run;

import core.BinaryTree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		
		BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
		
		integerBinaryTree.add(10);
		integerBinaryTree.add(20);
		integerBinaryTree.add(43);
		integerBinaryTree.add(45);
		integerBinaryTree.add(6);
		integerBinaryTree.add(2);
		integerBinaryTree.add(7);
		integerBinaryTree.add(8);
		integerBinaryTree.add(1);
		integerBinaryTree.add(84);
		integerBinaryTree.add(26);
		integerBinaryTree.add(83);
		integerBinaryTree.add(14);
		integerBinaryTree.add(75);
		
//		integerBinaryTree.inOrder(n -> System.out.print(Integer.toString(n) + " "));
//		System.out.println();
		
		integerBinaryTree.preOrder(n -> System.out.print(Integer.toString(n) + " "));
		System.out.println();
		
//		integerBinaryTree.postOrder(n -> System.out.print(Integer.toString(n) + " "));
//		System.out.println();
		
		integerBinaryTree.delete(2);
		
		integerBinaryTree.preOrder(n -> System.out.print(Integer.toString(n) + " "));
		System.out.println();
	}
}