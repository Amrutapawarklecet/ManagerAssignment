package com.marlabs.training.composition.main;

import com.marlabs.training.composition.Person;

public class Main {

	public static void main(String[] args) {
        Person person = new Person();
        long salary = person.getSalary();
        System.out.println(person.getSalary());
    }

}
