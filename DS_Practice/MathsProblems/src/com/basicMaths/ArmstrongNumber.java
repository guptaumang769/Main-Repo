package com.basicMaths;

/*Problem Statement: Given an integer N, return true it is an Armstrong number otherwise return false.

An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.*/

public class ArmstrongNumber {
	
	public static boolean isArmstrong(int N) {
		// Calculate the number of
		// digits in the given number
		int k = String.valueOf(N).length();
		int sum = 0;
		int n = N;
		while (n > 0) {
			int ld = n % 10;
			sum += Math.pow(ld, k);
			n = n / 10;
		}

		return sum == N ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 153;
        if (isArmstrong(N)) {
            System.out.println(N + " is an Armstrong number.");
        } else {
            System.out.println(N + " is not an Armstrong number.");
        }

	}

}
