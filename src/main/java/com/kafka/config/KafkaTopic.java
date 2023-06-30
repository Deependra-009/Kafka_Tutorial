package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
	
	@Bean
	public NewTopic javaguideTopics() {
		return TopicBuilder.name("javaguides").build();
	}
	
	@Bean
	public NewTopic javaguideJsonTopics() {
		return TopicBuilder.name("java_json_guides").build();
	}

}
