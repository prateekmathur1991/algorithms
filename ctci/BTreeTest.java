package ctci;

import java.util.HashSet;
import java.util.Random;

public class BTreeTest {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.insert(10);
		tree.insert(2);
		tree.insert(20);
		tree.insert(5);
		tree.insert(22);
		tree.insert(35);
		tree.insert(25);
		
		tree.inorder();
		System.out.println();
		
		System.out.println(tree.isBalanced());
	}

}
