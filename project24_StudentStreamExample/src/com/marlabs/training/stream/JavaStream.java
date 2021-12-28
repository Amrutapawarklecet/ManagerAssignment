package com.marlabs.training.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStream {
	public static void main(String[] args) {
		List<Student> student = new ArrayList<Student>();

		// Adding Students
		student.add(new Student(101, "Abhilasha", 95));
		student.add(new Student(102, "Afreen", 93));
		student.add(new Student(103, "Amruta", 90));
		student.add(new Student(104, "Samidha", 89));
		student.add(new Student(105, "Archana", 91));

		// Converting Student List into a Map
		Map<Integer, String> studentList = student.stream().filter(s -> s.marks > 90)
				.collect(Collectors.toMap(s -> s.id, s -> s.name));

		System.out.println(studentList);
	}
}
