package datastructures.linkedlists;

import javax.print.attribute.IntegerSyntax;

public class List<T> {
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name;

	public List() {
		this("List");
	}

	public List(String listName) {
		name = listName;
		firstNode = lastNode = null;
	}

	public static void main(String[] args) {

		List<Integer> integerList = new List<Integer>();
		integerList.insertAtFront(1011);
		integerList.print();
		System.out.println("============================");
		integerList.insertAtFront(1010);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtFront(1009);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtFront(1008);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtFront(1007);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtFront(1006);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtFront(1005);
		integerList.print();
		System.out.println("============================");

		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		integerList.insertAtBack(900);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtBack(901);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtBack(902);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtBack(903);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtBack(904);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtBack(905);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtBack(906);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtBack(907);
		integerList.print();
		System.out.println("============================");

		System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIII");

		integerList.insertAtIndex(5000, 5);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtIndex(5001, 2);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtIndex(5002, 7);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtIndex(5003, 9);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtIndex(5004, 11);
		integerList.print();
		System.out.println("============================");

		integerList.insertAtIndex(5005, 13);
		integerList.print();
		System.out.println("============================");

		System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		integerList.removeAllFromBack();

	}

	public void removeAllFromBack() {
		ListNode<T> currentNode = firstNode;

		while (null != currentNode) {
			removeFromBack();
			print();
			System.out.println("============================");
		}
	}

	public void removeAllFromFront() {
		ListNode<T> currentNode = firstNode;

		while (null != currentNode) {
			removeFromFront();
			print();
			System.out.println("============================");
		}
	}

	// insert an item at the front of the list
	public void insertAtFront(T insertItem) {
		// first check if list is empty.
		if (isEmpty()) {
			// start a new node
			firstNode = lastNode = new ListNode<T>(insertItem);
		} else {

			// list is not empty, find the head and insert it before
			// i.e. the old head would be the next listNode
			ListNode<T> newFirstNode = new ListNode<T>(insertItem, firstNode);
			newFirstNode.nextNode = firstNode;
			firstNode = newFirstNode;

		}
	}

	// insert a node item to the back of the list.
	public void insertAtBack(T insertItem) {
		// if list is empty,
		if (isEmpty()) {
			firstNode = lastNode = new ListNode<T>(insertItem);
		} else {
			ListNode<T> newLastNode = new ListNode<T>(insertItem);
			lastNode.nextNode = newLastNode;
			lastNode = newLastNode;
		}
	}

	public void insertAtIndex(T insertItem, int index) {
		// starting from the head, count in until we reach index
		int counter = 0;

		ListNode<T> currentNode = firstNode;
		while (null != currentNode) {
			if (counter == index) {
				// insert the node here
				ListNode<T> newNode = new ListNode<T>(insertItem,
						currentNode.nextNode);

				currentNode.nextNode = newNode;
				return;
			}

			currentNode = currentNode.nextNode;
			counter++;

		}
	}

	// we should thrown an exception if the list is empty
	// then check if we only have 1 node in our linked list.
	// if we do then set both to null
	// else set the new first node to what the old first node's next was
	// pointing to.
	public T removeFromFront() {
		T removedItem = firstNode.data;
		if (firstNode == lastNode) {
			firstNode = lastNode = null;
		} else {
			firstNode = firstNode.nextNode;
		}

		return removedItem;
	}

	public T removeFromBack() {
		T removedItem = lastNode.data;

		if (firstNode == lastNode) {
			firstNode = lastNode = null;
		} else {

			// need to go through the linked list and find the second to last
			ListNode<T> currentNode = firstNode;

			while (currentNode.nextNode != lastNode) {
				currentNode = currentNode.nextNode;
			}

			// we have the node before the last node.
			currentNode.nextNode = null;
			lastNode = currentNode;
		}

		return removedItem;
	}

	// if the first node is empty, then we have an empty list
	public boolean isEmpty() {
		return null == firstNode;
	}

	// traverse the LL and print out each data
	public void print() {
		int counter = 0;
		if (!isEmpty()) {

			// get the first node of the head
			ListNode<T> currentNode = firstNode;

			// continue until there is no next pointer
			while (null != currentNode) {

				System.out.println(counter + ": " + currentNode.data);
				currentNode = currentNode.nextNode;
				counter++;
			}
		}
	}
}

class ListNode<T> {

	T data;
	ListNode<T> nextNode;

	// this constructor is used when the next node is null
	ListNode(T object) {
		this(object, null);
		System.out.println("Next Node will be null");
	}

	// this constructor is used when the next node is not null
	// this would be used when we are inserting something in between something.
	ListNode(T object, ListNode<T> node) {
		data = object;
		nextNode = node;
	}

	T getData() {
		return data;
	}

	ListNode<T> getNext() {
		return nextNode;
	}
}
