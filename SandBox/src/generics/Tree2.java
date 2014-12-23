package generics;

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
	// package access members
	TreeNode<T> leftNode; // left node
	T data; // node value
	TreeNode<T> rightNode; // right node

	// constructor initializes data and makes this a leaf node
	public TreeNode(T nodeData) {
		data = nodeData;
		leftNode = rightNode = null; // node has no children
	} // end TreeNode constructor

	// locate insertion point and insert new node; ignore duplicate values
	public void insert(T insertValue) {
		// insert in left subtree
		if (insertValue.compareTo(data) < 0) {
			// insert new TreeNode
			if (leftNode == null)
				leftNode = new TreeNode<T>(insertValue);
			else
				// continue traversing left subtree recursively
				leftNode.insert(insertValue);
		} // end if
			// insert in right subtree
		else if (insertValue.compareTo(data) > 0) {
			// insert new TreeNode
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else
				// continue traversing right subtree recursively
				rightNode.insert(insertValue);
		} // end else if
	} // end method insert
} // end class TreeNode

// class Tree definition
public class Tree2<T extends Comparable<T>> {
	private TreeNode<T> root;

	// constructor initializes an empty Tree of integers
	public Tree2() {
		root = null;
	} // end Tree no-argument constructor

	// insert a new node in the binary search tree
	public void insertNode(T insertValue) {
		if (root == null)
			root = new TreeNode<T>(insertValue); // create root node
		else
			root.insert(insertValue); // call the insert method
	} // end method insertNode

	// begin preorder traversal
	public void preorderTraversal() {
		preorderHelper(root);
	} // end method preorderTraversal

	// recursive method to perform preorder traversal
	private void preorderHelper(TreeNode<T> node) {
		if (node == null)
			return;

		System.out.printf("%s ", node.data); // output node data
		preorderHelper(node.leftNode); // traverse left subtree
		preorderHelper(node.rightNode); // traverse right subtree
	} // end method preorderHelper

	// begin inorder traversal
	public void inorderTraversal() {
		inorderHelper(root);
	} // end method inorderTraversal

	// recursive method to perform inorder traversal
	private void inorderHelper(TreeNode<T> node) {
		if (node == null)
			return;

		inorderHelper(node.leftNode); // traverse left subtree
		System.out.printf("%s ", node.data); // output node data
		inorderHelper(node.rightNode); // traverse right subtree
	} // end method inorderHelper

	// begin postorder traversal
	public void postorderTraversal() {
		postorderHelper(root);
	} // end method postorderTraversal

	// recursive method to perform postorder traversal
	private void postorderHelper(TreeNode<T> node) {
		if (node == null)
			return;

		postorderHelper(node.leftNode); // traverse left subtree
		postorderHelper(node.rightNode); // traverse right subtree
		System.out.printf("%s ", node.data); // output node data
	} // end method postorderHelper

	public static void main(String args[]) {

		Tree2<Integer> tree = new Tree2<Integer>();
		int intVal;

		System.out.println("Inserting the following values: ");

		for (int i = 1; i <= 10; i++) {
			intVal = (int) (Math.random() * 100);
			System.out.print(intVal + " ");
			tree.insertNode(intVal);
		}

		System.out.println("\n\nPreorder traversal");
		tree.preorderTraversal();

		System.out.println("\n\nInorder traversal");
		tree.inorderTraversal();

		System.out.println("\n\nPostorder traversal");
		tree.postorderTraversal();
		System.out.println();

	}

} // end class Tree

