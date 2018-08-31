package com.demo.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**********************************************
 * 
 * @author pgobin
 *
 */
@Component
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	/*******************************
	 * 
	 * @param topic
	 * @param payload
	 */
	public ListenableFuture<SendResult<String, String>> send(String topic, String payload)
	{
		System.out.println("Message: " + payload + " sent to topic: " + topic);
		return kafkaTemplate.send(topic, payload);
	}
}
