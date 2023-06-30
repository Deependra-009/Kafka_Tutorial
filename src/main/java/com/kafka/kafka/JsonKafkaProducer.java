package com.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.payload.User;

@Service
public class JsonKafkaProducer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public void sendMessage(User data) {
		
		LOGGER.info(String.format("JSON Message sent: %s", data.toString()));
		
		Message<User> message=MessageBuilder.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "java_json_guides")
				.build();
		
		this.kafkaTemplate.send(message); 
	}
	

}
