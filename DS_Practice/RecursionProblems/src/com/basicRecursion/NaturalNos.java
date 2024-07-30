package com.basicRecursion;

/*Problem: Print from 1 to N using Recursion*/

public class NaturalNos {
	
	static void naturalNos(int i, int n) {
		if(i>n) return;
		System.out.println(i);
		naturalNos(i+1, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		naturalNos(1, n);
	}

}
