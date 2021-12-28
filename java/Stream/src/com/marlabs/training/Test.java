package com.marlabs.training;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		List<Student> student = new ArrayList<Student>();
// Adding Students
		student.add(new Student(101, "Abhilasha", 95));
		student.add(new Student(102, "Afreen", 93));
		student.add(new Student(103, "Amruta", 90));
		student.add(new Student(104, "Samidha", 89));
		student.add(new Student(105, "Archana", 91));
		List<String> studentList = student.stream().filter(s -> s.marks > 90)// filtering data
				.map(s -> s.name) // fetching name
				.collect(Collectors.toList()); // collecting as list
		System.out.println(studentList);
	}
}
