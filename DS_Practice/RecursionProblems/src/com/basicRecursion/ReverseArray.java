package com.basicRecursion;

/*Problem Statement: You are given an array. The task is to reverse the array and print it.*/ 

public class ReverseArray {
	
	static void reverse(int arr[]) {
		int n = arr.length;
		int first = 0;
		int last = n-1;
		while(first < last) {
			int tmp = arr[first];
			arr[first] = arr[last];
			arr[last] = tmp;
			first++;
			last--;
		}
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	//Using recursion
	static void reverseArray(int arr[], int start, int end) {
		
		if(start < end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			reverseArray(arr, start+1, end-1);
		}

	}
	
	static void printArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 7, 9};
		int n = arr.length;
		reverseArray(arr, 0, n-1);
		printArray(arr);
	}

}
