package com.demo.app.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@EnableScheduling
@Component
public class MessageProducerMock {

	@Autowired
	ProducerService producerService;

	@Value("${spring.application.name:APP}")
	String appName;

	/*****************************************************************
	 * 	
	 */
	@Scheduled(fixedRateString = "1000", initialDelay = 10000)
	public void sendMessageTopic1()
	{
		String message = "[" + appName + "] hello";
		ListenableFuture<SendResult<String, String>> sendResult = producerService.send("topic1", message);

	}
	
	@Scheduled(fixedRateString = "3000", initialDelay = 10000)
	public void sendMessageTopic2()
	{
		String message = "[" + appName + "] hello [" + Instant.now() + "]";
		ListenableFuture<SendResult<String, String>> sendResult = producerService.send("topic2", message);

	}

}
