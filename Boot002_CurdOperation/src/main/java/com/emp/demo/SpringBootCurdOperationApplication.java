package com.emp.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emp.demo.entity.Employee;
import com.emp.demo.repository.EmpRepository;


@SpringBootApplication
public class SpringBootCurdOperationApplication  implements CommandLineRunner{

	@Autowired
	EmpRepository empRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdOperationApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Employee e1=new Employee(1,"Afreen","Dehli");
		Employee e2=new Employee(2,"Abhi","Mysore");
		
		empRepository.employee.addAll(Arrays.asList(e1,e2));
		
	}

}
