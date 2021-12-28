package com.marlabs.training.inheritance;

public class Lion extends Feline {

	@Override
	public void callSound() {
		super.callSound();
	}

	@Override
	public int run() {
		return 40;
	}
}
