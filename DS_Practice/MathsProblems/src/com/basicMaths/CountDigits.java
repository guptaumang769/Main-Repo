package com.basicMaths;

/*Problem Statement: 
 * 		Given an integer N, return the number of digits in N.*/



public class CountDigits {
	
	/*Time Complexity: O(log10N + 1) where N is the input number. 
	 * The time complexity is determined by the number of digits in the input integer N. 
	 * In the worst case when N is a multiple of 10 the number of digits in N is log10N + 1. 
	 * In the while loop we divide N by 10 until it becomes 0 which takes log10N iterations. 
	 * In each iteration of the while loop we perform constant time operations like division and increment the counter.

	Space Complexity : O(1) as only a constant amount of additional memory for the counter regardless of size of the input number.*/
	
	public static void count(int N) {
		int count = 0;
		while (N > 0) {
			N = N / 10;

			count++;
		}
		System.out.println("No of digits:- " + count);
	}
	
	//Optimal Approach 
	/*
	 * Time Complexity: O(1)as simple arithmetic operations in constant time are
	 * computed on integers.
	 * 
	 * Space Complexity : O(1)as only a constant amount of additional memory for the
	 * count variable regardless of size of the input number.
	 */
	public static int countDigits(int N) {
		int count = (int) (Math.log10(N) + 1);

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 387654;
		System.out.println("The number is: "+N);
		//count(N);
		System.out.println("Total digits are: "+ countDigits(N));
	}

}
