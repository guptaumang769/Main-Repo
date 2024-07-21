package com.patterns;

/*Print the below pattern
* 		A
* 		A B
* 		A B C
* 		A B C D 
* 		A B C D E
* */

public class IncreasingAlphabetTriangle {
	
	static void pattern14(int N) {
		for(int i=0; i<N; i++) {
			for(char ch='A'; ch<='A'+i; ch++) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=5;
		pattern14(N);
	}

}
