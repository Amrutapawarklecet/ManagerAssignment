package com.marlabs.training.inheritance;

abstract class Canine implements Animal {
	@Override
	public void callSound() {
		System.out.println("howl");
	}
}
