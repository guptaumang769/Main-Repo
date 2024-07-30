package com.basicRecursion;

/*Problem Statement: Given an integer N. Print the Fibonacci series up to the Nth term.*/

public class FibonacciSeries {
	
	static int fibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		
		int last = fibonacci(n-1);
		int slast = fibonacci(n-2);
		
		return last + slast;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(fibonacci(n));
	}

}
