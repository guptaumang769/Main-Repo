package com.patterns;

/*Print the below pattern
 * 		  *
 * 		 ***
 * 		*****
 * 	   *******
 * 	  *********
 * */

public class StarPyramid {
	
	static void pattern7(int n) {
		for(int i=0; i<n; i++) {
			//space
			for(int j=0; j<=n-i-1; j++) {
				System.out.print(" ");
			}
			//star
			for(int j=0; j<2*i+1; j++) {
				System.out.print("*");
			}
			
			//space
			for(int j=0; j<=n-i-1; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		pattern7(n);

	}

}
