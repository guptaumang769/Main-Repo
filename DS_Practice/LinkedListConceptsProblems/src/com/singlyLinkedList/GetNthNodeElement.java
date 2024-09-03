package com.singlyLinkedList;

public class GetNthNodeElement {
	
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
	
	// Function to find the nth node in the list iteratively
    static int getNthNodeIterative(Node head, int index) {
        Node current = head;
        int count = 1;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        return -1;
    }

	public static void main(String[] args) {
		int[] arr = {2, 5, 8, 7, 3, 100};
        // Creating a new Node with the value from the array
		Node head = convertArrToLL(arr);
		int idx = 3;
		int element = getNthNodeIterative(head, idx);
		System.out.println("Element present at index "+idx+" is: "+element);
		printList(head);

	}

}
