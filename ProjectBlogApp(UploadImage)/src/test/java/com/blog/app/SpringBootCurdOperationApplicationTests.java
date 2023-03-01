package com.blog.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.app.repositories.UserRepo;

@SpringBootTest
class SpringBootCurdOperationApplicationTests {

	
	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void RepoTest() {
		
	String className=userRepo.getClass().getName();
	Package packageName=userRepo.getClass().getPackage();
	
	System.out.println("Class name:" +className);
	System.out.println("Pacakge name:" +packageName);

	}
	
	

}
