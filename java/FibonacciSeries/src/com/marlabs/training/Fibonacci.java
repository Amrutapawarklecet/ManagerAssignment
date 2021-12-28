package com.marlabs.training;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number");
		int n = sc.nextInt();
		int a = 0;
		int b = 1;
		int c;
		System.out.println(a);
		System.out.println(b);
		for (int i = 1; i <= n; i++) {
			c = a + b;// 1+0
			a = b;
			b = c;
			System.out.println(c);
		}
	}

}
