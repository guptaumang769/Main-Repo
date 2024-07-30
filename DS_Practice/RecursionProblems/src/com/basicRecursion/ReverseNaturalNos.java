package com.basicRecursion;

/*Problem: Print from N to 1 using Recursion*/

public class ReverseNaturalNos {
	
	static void func(int i, int n) {
		if(i<1) return;
		System.out.println(i);
		func(i-1, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		func(n, n);
	}

}
