package com.basicMaths;

/*Problem Statement: Given an integer N, return true if it is a palindrome else return false.
 * 
 * A palindrome is a number that reads the same backward as forward. 
 * For example, 121, 1331, and 4554 are palindromes because they remain the same when their digits are reversed.*/

public class Palindrome {
	
	public static boolean checkPalindrome(int N) {
		int rev = 0;
		int original = N;
		while (N > 0) {
			int ld = N % 10;
			rev = rev * 10 + ld;
			N = N / 10;
		}
		return rev == original ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 121;
		if (checkPalindrome(N)) {
            System.out.println(N + " is an Palindrome number.");
        } else {
            System.out.println(N + " is not an Palindrome number.");
        }
	}

}
