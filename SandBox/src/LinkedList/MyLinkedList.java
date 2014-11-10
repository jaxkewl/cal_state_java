package LinkedList;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class MyLinkedList {

	int listCount;
	Node head;

	public MyLinkedList() {
		listCount = 0;
		head = new Node();
	}

	// this list contains whatever, in this case, it contains integers.
	public void addNodeToEnd(Object item) {

		// init currentNode to the first node
		Node currentNode = head;

		if (null == currentNode.data) {
			// nothing is in our list, add the first item and return
			head = new Node();
			head.data = item;
			head.nextNode = null;
			listCount++;
			return;
		}

		// find the end of the list
		while (null != currentNode.nextNode) {

			currentNode = currentNode.nextNode;
		}

		// we found the last node. add the item to the end
		Node newNode = new Node();
		newNode.data = item;

		// set the currentNode's next to this newNode
		currentNode.nextNode = newNode;
		listCount++;
	}

	// node contains the data for each item plus a pointer to the next node
	private class Node {
		Object data;
		Node nextNode;

	}
}
