package com.singlyLinkedList;

public class ReverseLinkedList {
	
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
	
	/* reverse the list and return the head of reversed list */
	public static Node reverseList(Node head) {
        
        Node curr = head, prev = null, next;

        while (curr != null) {
            
            next = curr.next;            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

	public static void main(String[] args) {
		int[] arr = {2, 5, 8, 7, 3, 100};
        // Creating a new Node with the value from the array
		Node head = convertArrToLL(arr);
		head = reverseList(head);
		printList(head);
	}

}
