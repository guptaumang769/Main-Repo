package com.basicRecursion;

/*Problem statement: Given a number ‘N’, find out the sum of the first N natural numbers.*/

public class SumOfNaturalNos {
	
	//Parameterized Way
	static void func(int i, int sum) {
		if(i<1) {
			System.out.println(sum);
			return;
		}
		
		func(i-1, sum+i);
	}
	
	//Functional way
	static int funct(int n) {
		if(n==0) 
			return 0;
		return n + funct(n-1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		func(n, 0);
		System.out.println(funct(4));
	}

}
