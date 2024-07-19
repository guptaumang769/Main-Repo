package com.patterns;

/*Print the below pattern
 * 		*****
 * 		****
 * 		***
 * 		**
 * 		*
 * */

public class InvertedRightPyramid {
	
	static void pattern5(int n) {
		for(int i=0; i<n; i++) {
			for(int j=n; j>i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		/*
		 * for(int i=1; i<=n; i++) { for(int j=1; j<=n-i+1; j++) {
		 * System.out.print("*"); } System.out.println(""); }
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		pattern5(n);
	}

}
