package com.singlyLinkedList;

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
};

public class InsertOperationOnLinkedList {
	
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

	/* insert at head position */
	public static Node insertHead(Node head, int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		return newNode;
	}
	
	/* insert at last position */
	public static Node insertLast(Node head, int val) {
		Node newNode = new Node(val);
		if(head == null) {
			return newNode;
		}
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		
		return head;
	}
	
	/* insert at specific position */
	public static Node insertAtPosition(Node head, int position, int data) {
		Node newNode = new Node(data);
		
		if(head == null) return newNode;
		
		if(position == 1) {
			newNode.next = head;
			head = newNode;
			return head;
		}
		
		Node current = head;
		
		for (int i = 1; i < position - 1 && current != null; ++i) {
	            current = current.next;
	        }
		
		if (current == null) {
            System.out.println("Position is out of bounds.");
            return head;
        }
		
		newNode.next = current.next;
        current.next = newNode;
		
		return head;
	}
	
	// Function to insert a new node after a given node
    public static Node insertAfter(Node head, int key, int newData)
    {
        Node curr = head;

        while (curr != null) {
            if (curr.data == key)
                break;
            curr = curr.next;
        }

        if (curr == null)
            return head;

        Node newNode = new Node(newData);
        newNode.next = curr.next;
        curr.next = newNode;
        
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 5, 8, 7};
        // Creating a new Node with the value from the array
		Node head = convertArrToLL(arr);
		head = insertHead(head, 100);
		printList(head);
		head = insertLast(head, 4);
		printList(head);		
	}

}
