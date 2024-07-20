package com.basicMaths;

import java.util.ArrayList;

/*Problem Statement: Given an integer N, return all divisors of N. 
 * 
 * A divisor of an integer N is a positive integer that divides N without leaving a remainder. 
 * In other words, if N is divisible by another integer without any remainder, then that integer is considered a divisor of N.*/

public class AllDivisors {
	
	public static ArrayList<Integer> findDivisors(int N) {
		ArrayList<Integer> divisors = new ArrayList<>();
		int sqrtN = (int) Math.sqrt(N);

		for (int i = 1; i <= sqrtN; i++) {
			if (N % i == 0) {
				divisors.add(i);
				if (i != N / i) {
					divisors.add(N / i);
				}
			}
		}

		return divisors;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 12;
		ArrayList<Integer> divisors = findDivisors(number);

		System.out.print("Divisors of " + number + " are: ");
		for (int divisor : divisors) {
			System.out.print(divisor + " ");
		}
		System.out.println();
	}

}
