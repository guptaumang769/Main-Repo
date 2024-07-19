package com.patterns;

/*Print the below pattern
 * 		  *********
 		   ******* 
            *****  
             ***   
              *    
 * */

public class InvertedStarPyramid {
	
	static void pattern8(int n) {
		for(int i=0; i<n; i++) {
			//space
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			//star
			for(int j=0; j<2*n - (2*i+1); j++) {
				System.out.print("*");
			}
			
			//space
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		pattern8(n);

	}

}
