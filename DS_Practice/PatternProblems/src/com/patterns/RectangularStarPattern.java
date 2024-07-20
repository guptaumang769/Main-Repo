package com.patterns;

/*Print the below pattern
 * 		*****
 * 		*****
 * 		*****
 * 		*****
 * 		*****
 * */
public class RectangularStarPattern {
	
	static void pattern1(int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		pattern1(n);
	}

}
