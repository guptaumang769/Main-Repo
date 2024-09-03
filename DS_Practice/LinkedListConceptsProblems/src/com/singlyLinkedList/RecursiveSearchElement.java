package com.singlyLinkedList;

public class RecursiveSearchElement {
	
	public static Node convertArrToLL(int[] arr) {
		Node head = new Node(arr[0]);
		Node move = head;
		for(int i=1; i<arr.length; i++) {
			Node temp = new Node(arr[i]);
			move.next = temp;
			move = temp;
		}
		return head;
	}
	
	public static void printList(Node head) {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data+ " ");
			curr=curr.next;
		}
		System.out.println();
	}
	
	// Checks whether the key is present in linked list
    static boolean searchKey(Node head, int key) {

        if (head == null)
            return false;

        if (head.data == key)
            return true;

        return searchKey(head.next, key);
    }
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 8, 7, 3, 100};
        // Creating a new Node with the value from the array
		Node head = convertArrToLL(arr);
		int key = 4;
		if(searchKey(head, key)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
