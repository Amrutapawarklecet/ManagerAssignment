package com.marlabs.training.inheritance;

public class Cat extends Feline {

	@Override
	public void callSound() {
		System.out.println("meow");
	}

	@Override
	public int run() {
		return 30;
	}
}
