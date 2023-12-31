package com.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.payload.User;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics="javaguides",groupId="myGroup ")
	public void consume(String message) {
		LOGGER.info(String.format("Message Recieved: %s", message));
		
	}
	
	@KafkaListener(topics="java_json_guides",groupId="myGroup ")
	public void consumeJson(User message) {
		LOGGER.info(String.format("Message Recieved: %s", message));
		
	}

}
