package run;

import core.BinaryTree;

public class BinaryTreeTest {

	public static void main(String[] args) {

		BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
		Integer [] arr = {10, -9, 4, 34, 3, 22, 77};
		
		integerBinaryTree.addAll(arr);
		
		integerBinaryTree.inOrder(t -> System.out.print(t.toString() + " "));
		System.out.println();

		integerBinaryTree.preOrder(t -> System.out.print(t.toString() + " "));
		System.out.println();

		integerBinaryTree.postOrder(t -> System.out.print(t.toString() + " "));
		System.out.println();
	}
}