package com.marlabs.training.inheritance.main;

import com.marlabs.training.inheritance.Animal;
import com.marlabs.training.inheritance.Cat;
import com.marlabs.training.inheritance.Lion;

public class Main {
	public static void main(String args[]) {

		Animal[] animals = new Animal[2];
		animals[0] = new Cat();
		animals[1] = new Lion();

		for (int i = 0; i < animals.length; i++) {
			animals[i].callSound();
			System.out.println(animals[i].run());

		}
	}
}
