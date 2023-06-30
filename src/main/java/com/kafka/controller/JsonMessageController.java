package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafka.JsonKafkaProducer;
import com.kafka.payload.User;

@RestController
@RequestMapping("api/v1/jsonkafka")
public class JsonMessageController {
	
	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	
	@PostMapping("/publish")
	private ResponseEntity<User> publish(@RequestBody User user){
		
		this.jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok(user);
		
	}

}
