package generics;

// this defines each node in a tree node
class TreeNode<T extends Comparable<T>> {

	// you need a left
	TreeNode<T> leftNode;

	// you need a right
	TreeNode<T> rightNode;

	// need a generic data
	T data1;

	public TreeNode(T insertValue) {
		data1 = insertValue;
		leftNode = rightNode = null;
	}

	public void insert(T insertValue) {

		// determine if the insertValue is less than the root.
		// remember we always start off with the root.
		if (insertValue.compareTo(data1) <= 0) {
			// need to traverse down the left subtree

			if (null == leftNode) {
				leftNode = new TreeNode<T>(insertValue);
			} else {
				// we have a left node, we need to do a recursive search
				leftNode.insert(insertValue);
			}

		} else if (insertValue.compareTo(data1) > 0) {

			if (null == rightNode) {
				rightNode = new TreeNode<T>(insertValue);
			} else {
				// we have a right node, we need to do a recursive search
				rightNode.insert(insertValue);
			}
		}
	}
}

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public Tree() {
		root = null;
	}

	public void insertNode(T value) {
		if (null == root) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
