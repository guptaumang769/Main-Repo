package com.basicRecursion;

/*Problem: Print your name N times using Recursion*/

public class NameNTimes {
	
	static void func(int i, int n) {
		if(i>n) return;
		System.out.println("Umang");
		func(i+1, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		func(1, n);
	}

}
