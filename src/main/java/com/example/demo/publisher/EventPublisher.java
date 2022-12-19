package com.example.demo.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserEvent;

@Component
public class EventPublisher {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void addUser(String user) {
		System.out.println("user is = " + user);
		applicationEventPublisher.publishEvent(new UserEvent(user));
	}

}
