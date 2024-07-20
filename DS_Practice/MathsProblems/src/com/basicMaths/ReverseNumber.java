package com.basicMaths;

/*Problem Statement: Given an integer N return the reverse of the given number.

Note: If a number has trailing zeros, then its reverse will not include them. 
		For e.g., reverse of 10400 will be 401 instead of 00401.*/

public class ReverseNumber {
	
	public static int reverse(int N) {
		int rev = 0, ld;
		while (N > 0) {
			ld = N % 10;
			rev = rev * 10 + ld;
			N = N / 10;
		}

		return rev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 34215;
		System.out.println("The no is: "+N);
		System.out.println("The reverse No is: "+reverse(N)); 
	}

}
