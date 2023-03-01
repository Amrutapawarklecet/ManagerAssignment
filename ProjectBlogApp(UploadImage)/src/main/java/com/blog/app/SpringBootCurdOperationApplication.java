package com.blog.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//This is the key annotation of application.It is the staring point of main application.
@SpringBootApplication
public class SpringBootCurdOperationApplication{


	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdOperationApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
	
}

