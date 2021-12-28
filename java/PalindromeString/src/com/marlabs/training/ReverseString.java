package com.marlabs.training;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String s1= sc.nextLine();
		String s2="";
		for (int i = s1.length() - 1; i >= 0; i--) {
		    s2=s2+s1.charAt(i);
		}
		System.out.println(s2);
		if(s1.equals(s2)) {
			System.out.println(s1+" is palindrome");
		}
		else {
			System.out.println(s1+" is not palindrome");
		}
	}
}
