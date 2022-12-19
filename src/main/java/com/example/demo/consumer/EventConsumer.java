package com.example.demo.consumer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserEvent;


@Component
public class EventConsumer {

	@EventListener
	public void handler(UserEvent userEvent) {
		System.out.println("Event received.");
		System.out.println("User event " + userEvent.getName());
	}

}
