package com.basicRecursion;

/*Problem Statement: "Given a string, check if the string is palindrome or not."  
 * A string is said to be palindrome if the reverse of the string is the same as the string.*/

public class StringPalindrome {
	
	static boolean palindrome(int i, String s){
        
        // Base Condition
        // If i exceeds half of the string, means all the elements 
        // are compared, we return true.
        if(i>=s.length()/2) return true;
        
        // If start is not equal to end, not palindrome.
        if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        
        // If both characters are same, increment i and check start+1 and end-1.
        return palindrome(i+1,s);
        
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "masdam";
		System.out.println(palindrome(0, s));
	}

}
