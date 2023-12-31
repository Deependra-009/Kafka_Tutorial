package com.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Service
@AllArgsConstructor
@Getter
@Setter
public class KafkaProducer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		LOGGER.info(String.format("Message Sent %s", message));
		this.kafkaTemplate.send("javaguides", message);
	}

}
