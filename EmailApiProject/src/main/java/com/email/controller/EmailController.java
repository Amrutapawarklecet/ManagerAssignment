package com.email.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.RequestEmail;
import com.email.service.EmailService;

@RestController
@RequestMapping("/api/email/")
public class EmailController {
	
	private EmailService emailService;

	@GetMapping("/welcome")
	public String welcome() {
		return "hello this is my email api";
	}
	
	@PostMapping("/")
	public ResponseEntity<?> sendEmail(@RequestBody RequestEmail request){
		boolean sendEmail = emailService.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
		System.out.println(request);
		return ResponseEntity.ok("done");
//		if(sendEmail) {
//		return new ResponseEntity<>(sendEmail,HttpStatus.CREATED);
//		}
//		else {
//			return new ResponseEntity<>(sendEmail,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
}
