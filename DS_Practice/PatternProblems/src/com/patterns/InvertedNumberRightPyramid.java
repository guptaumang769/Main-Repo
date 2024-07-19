package com.patterns;

/*Print the below pattern
 * 		12345
 * 		1234
 * 		123
 * 		12
 * 		1
 * */

public class InvertedNumberRightPyramid {
	
	static void pattern6(int n) {
		/*
		 * for(int i=0; i<n; i++) { for(int j=n; j>i; j--) { System.out.print(n-j+1); }
		 * System.out.println(""); }
		 */
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i+1; j++) {
				System.out.print(j);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		pattern6(n);
	}

}
