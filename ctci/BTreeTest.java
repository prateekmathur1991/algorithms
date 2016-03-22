package ctci;

public class BTreeTest {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.insert(2);
		tree.insert(8);
		tree.insert(10);
		tree.insert(12);
		tree.insert(14);
		tree.insert(16);
		
		tree.inorder();
		System.out.println();
		
		tree.preorder();
		System.out.println();
		
		System.out.println(tree.isBinarySearchTree());
		
		// System.out.println(tree.isBalanced());
	}

}
