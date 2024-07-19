package com.patterns;

/*Print the below pattern
 * 		1
 * 		22
 * 		333
 * 		4444
 * 		55555
 * */

public class RightAngledNumberPyramid {
	
	static void pattern4(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(i);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =5;
		pattern4(n);

	}

}
