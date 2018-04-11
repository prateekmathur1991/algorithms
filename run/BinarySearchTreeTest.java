package run;

import core.BinarySearchTree;

public class BinarySearchTreeTest {

	public static void main(String[] args) {

		BinarySearchTree<Integer> integerBinarySearchTree = new BinarySearchTree<>();
		Integer [] arr = {10, -9, 4, 34, 3, 22, 77};
		
		integerBinarySearchTree.addAll(arr);
		
		integerBinarySearchTree.inOrder(t -> System.out.print(t.toString() + " "));
		System.out.println();

		integerBinarySearchTree.preOrder(t -> System.out.print(t.toString() + " "));
		System.out.println();

		integerBinarySearchTree.postOrder(t -> System.out.print(t.toString() + " "));
		System.out.println();
	}
}