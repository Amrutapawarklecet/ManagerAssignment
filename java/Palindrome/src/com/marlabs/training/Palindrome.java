package com.marlabs.training;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number");
		int n = sc.nextInt();// 323
		int rem, rev = 0, temp;
		temp = n; // 323
		while (n > 0) { // 323>0 //32>0 //3>0 //0>0
			rem = n % 10; // 3 //2 //3
			rev = rev * 10 + rem; // 3 //32 //323
			n = n / 10;// 32 //3 //0
		}
		if (rev == temp) {
			System.out.println(temp + " is palindrome");
		} else {
			System.out.println(temp + " is  not palindrome");
		}
	}
}
