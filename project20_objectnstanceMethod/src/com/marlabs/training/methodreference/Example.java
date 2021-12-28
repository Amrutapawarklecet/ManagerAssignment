package com.marlabs.training.methodreference;

@FunctionalInterface
interface MyInterface {
	void display();
}

public class Example {
	public void myMethod() {
		System.out.println("Instance Method");
	}

	public static void main(String[] args) {
		Example obj = new Example();
		// Method reference using the object of the class
		MyInterface ref = obj::myMethod;
		// Calling the method of functional interface
		ref.display();
	}
}
