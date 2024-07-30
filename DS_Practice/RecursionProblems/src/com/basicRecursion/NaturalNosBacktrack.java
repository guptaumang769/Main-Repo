package com.basicRecursion;

/*Problem: Print from 1 to N using Recursion & Backtracking*/

public class NaturalNosBacktrack {
	
	static void func(int i, int n) {
		if(i<1) return;
		func(i-1, n);
		System.out.println(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		func(n, n);
	}

}
