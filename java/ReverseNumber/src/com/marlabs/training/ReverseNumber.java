package com.marlabs.training;
import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number");
		int n = sc.nextInt();//123
		int rem, rev = 0;
		while (n > 0) { //123>0 //12 //1 //
			rem = n % 10;//123%10=3, rem=3 //12%10= 2 ,rem=2 //1%10 =1
			rev = rev * 10 + rem;//0+3,rev=3 // 3*10+2=32 ,rev=32 //32*10+1 =321
			n = n / 10; //123/10=12.3 ->12 //12/10 ->1.2 ->1 //1/10 ->0.1 ->0
		}
		System.out.println("Reverse Number is:" + rev); //321

	}
}
