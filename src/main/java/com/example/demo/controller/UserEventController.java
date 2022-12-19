package com.example.demo.controller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.publisher.EventPublisher;

@RestController
public class UserEventController {

	@Autowired
	private EventPublisher eventPublisher;

	@PostMapping(value = "/send/user")
	public ResponseEntity<String> addUser(
			@RequestBody Map<String, String> user) {
		CompletableFuture
				.runAsync(() -> eventPublisher.addUser(user.get("name")));
		return new ResponseEntity<>("Order has been accepted",
				HttpStatus.ACCEPTED);
	}

}
