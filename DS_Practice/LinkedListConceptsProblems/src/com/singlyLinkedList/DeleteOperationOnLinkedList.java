package com.singlyLinkedList;

/* This is commented because Node class is already defined in Insert Operation class. 
 * It means it can access from the package.
  class Node{
    int data;
    Node next;
    Node(int data1, Node next1){
        this.data=data1;
        this.next=next1;
    }
    Node(int data1){
        this.data=data1;
        this.next=null;
    }
};*/

public class DeleteOperationOnLinkedList {
	
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
	
	// Function to delete the head node
    public static Node deleteHead(Node head)
    {
        if (head == null)
            return null;

        head = head.next;

        return head;
    }
    
    // Function to remove the last node of the linked list
    public static Node deleteLast(Node head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }

        secondLast.next = null;

        return head;
    }
    
 // Function to delete a node at a given position
    public static Node deleteNode(Node head, int position) {
        Node temp = head;
        Node prev = null;

        if (temp == null)
            return head;

        if (position == 1) {
            head = temp.next;
            return head;
        }

        for (int i = 1; temp != null && i < position; i++) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {
            prev.next = temp.next;
        }
        else {
            System.out.println("Data not present");
        }

        return head;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 5, 8, 7, 3, 100};
        // Creating a new Node with the value from the array
		Node head = convertArrToLL(arr);
		printList(head);
		head = deleteHead(head);
		printList(head);
		head = deleteLast(head);
		printList(head);
	}

}
