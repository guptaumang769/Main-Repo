package com.patterns;

/*Print the below pattern
* 		A
* 		B B
* 		C C C
* 		D D D D 
* 		E E E E E
* */

public class AlphaRamp {
	
	static void pattern16(int N) {
		char ch = 'A';
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(ch);
			}
			System.out.println();
			ch++;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=5;
		pattern16(N);
	}

	

}
