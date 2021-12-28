package com.marlabs.training;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array1");
		int m = sc.nextInt();// 2
		System.out.println("Enter the length of array2");
		int n = sc.nextInt();// 3
		int a[] = new int[m];
		int b[] = new int[n];

		if (m == n) {

			for (int i = 0; i < m; i++) {
				System.out.println("Enter the array1 element of index" + (i + 1));
				a[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				System.out.println("Enter the array2 element of index" + (i + 1));
				b[i] = sc.nextInt();
			}

			for (int i = 0; i < m; i++) {
				if (a[i] == b[i]) {
					System.out.println("Arrays are equal");
				} else {
					System.out.println("Arrays are not equal");
				}
			}

		} else {
			System.out.println("Arrays are not equal");
			System.exit(0);
		}
	}
}
