package com.learnjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	

	@GetMapping("/home")
	String home() {
		return "Hello World!";
	}

	@PostMapping("/broadcast")
	public String broadcadtMessage(@RequestBody String msg){
		simpMessagingTemplate.convertAndSend("/topic/greeting", msg);
		
		return "greeting delivered";
	}
}
