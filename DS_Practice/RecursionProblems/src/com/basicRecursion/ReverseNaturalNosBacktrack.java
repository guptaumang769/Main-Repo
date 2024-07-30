package com.basicRecursion;

/*Problem: Print from N to 1 using Recursion & Backtracking*/

public class ReverseNaturalNosBacktrack {
	
	static void func(int i, int n) {
		if(i>n) return;
		func(i+1, n);
		System.out.println(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		func(1, n);
	}

}
