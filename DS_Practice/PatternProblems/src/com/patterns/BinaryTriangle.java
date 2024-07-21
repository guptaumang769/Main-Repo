package com.patterns;

/*Print the below pattern
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1 
*/

public class BinaryTriangle {
	
	static void pattern11(int N) {
		int start = 1;
		
		for(int i=0; i<N; i++) {
			if(i%2 == 0) 
				start = 1;
			else
				start = 0;
			
			for(int j=0; j<=i; j++) {
				System.out.print(start);
				start = 1-start;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		pattern11(N);
	}

}
