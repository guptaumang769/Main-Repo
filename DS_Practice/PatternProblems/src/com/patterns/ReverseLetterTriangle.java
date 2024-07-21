package com.patterns;

/*Print the below pattern
* 		A B C D E
* 		A B C D
* 		A B C
* 		A B 
* 		A
* */

public class ReverseLetterTriangle {
	
	static void pattern15(int N) {
		for(int i=0; i<N; i++) {
			for(char ch='A'; ch<='A'+(N-i-1); ch++) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=5;
		pattern15(N);
	}

	

}
