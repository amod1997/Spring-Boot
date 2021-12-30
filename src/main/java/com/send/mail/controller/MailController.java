package com.send.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.send.mail.service.MailService;

@RestController
@RequestMapping("/send")
@CrossOrigin
public class MailController {

	@Autowired
	private MailService mailService;

	@GetMapping("/{userEmail}")
	public ResponseEntity<String> sendEmail(@PathVariable("userEmail") String userEmail) {
		return ResponseEntity.ok(mailService.sendEmail(userEmail));
	}

}
