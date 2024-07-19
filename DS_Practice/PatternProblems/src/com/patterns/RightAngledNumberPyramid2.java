package com.patterns;

/*Print the below pattern
 * 		1
 * 		12
 * 		123
 * 		1234
 * 		12345
 * */

public class RightAngledNumberPyramid2 {
	
	static void pattern3(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =5;
		pattern3(n);

	}

}
