package com.marlabs.training;

import java.util.Scanner;

public class Swap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  value of a ");
		int a = sc.nextInt();
		System.out.println("Enter the  value of b ");
		int b = sc.nextInt();
		System.out.println("Before Swaping:" + a + " " + b);
		int c;
		c = a;
		a = b;
		b = c;

		System.out.println("After Swaping:" + a + " " + b);
	}
}
