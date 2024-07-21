package com.patterns;

/*Print the below pattern
* 		1        1
* 		12      21
* 		123    321
* 		1234  4321
* 		1234554321
* */

/*For spaces, we can say that initially, spaces are 2*(N-1) for Row 1 where N is the total no. of rows
 *  and then the spaces decrease by 2 in each iteration till the last row is reached.*/

public class NumberCrown {
	
	static void pattern12(int N) {
		int spaces = 2*(N-1);
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			for(int j=1; j<=spaces; j++) {
				System.out.print(" ");
			}
			for(int j=i; j>=1; j--) {
				System.out.print(j);
			}
			System.out.println();
			spaces-=2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		pattern12(N);
	}

}
