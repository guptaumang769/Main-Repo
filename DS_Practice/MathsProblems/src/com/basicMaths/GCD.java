package com.basicMaths;

/*Problem Statement: Given two integers N1 and N2, find their greatest common divisor.

The Greatest Common Divisor of any two integers is the largest number that divides both integers.

*The Euclidean Algorithm is a method for finding the greatest common divisor of two numbers. 
*   It operates on the principle that the GCD of two numbers remains the same even if the smaller number 
*      is subtracted from the larger number.
*      
*      Eg, n1 = 20, n2 = 15:

		gcd(20, 15) = gcd(20-15, 15) = gcd(5, 15)

		gcd(5, 15) = gcd(15-5, 5) = gcd(10, 5)

		gcd(10, 5) = gcd(10-5, 5) = gcd(5, 5)

		gcd(5, 5) = gcd(5-5, 5) = gcd(0, 5)

		Hence, return 5 as the gcd.
		
For big nos, it will take a lot of steps and linear time complexity will increase. 
Now here is a catch.
 		If you see the above example, you will get that GCD(20, 15) = GCD(20%15, 15) = GCD(5, 15) before swapping.
 		So we can directly say that (bigger%smaller) and it will go until one of become 0.
 		If one of them is 0, the other is GCD.
 		
 		Time Complexity: O(log(min(N1, N2))) where N1 and N2 is the input number.
*/

public class GCD {
	
	//Brute Force Approach
	/*
	 * public static int findGcd(int n1, int n2) {
	 * 
	 * for (int i = Math.min(n1, n2); i>0; i--) { if (n1 % i == 0 && n2 % i == 0) {
	 * 
	 * return i; } } return 1; }
	 */
	
	static int findGcd(int a, int b) {
		
		while(a > 0 && b > 0) {
            if(a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        
        if(a == 0) {
            return b;
        }
        return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 20, n2 = 40;

        // Find the GCD of n1 and n2
        int gcd = findGcd(n1, n2);

        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcd);
		
	}

}
