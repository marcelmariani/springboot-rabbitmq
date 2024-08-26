package com.marcelmariani.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelmariani.config.CustomerConfig;
import com.marcelmariani.entity.Customer;

@Service
public class CustomerProducer {

	private static final Logger logger = LoggerFactory.getLogger(CustomerProducer.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public Customer sendMessage(Customer customer) {

		logger.info("sendMessage -> " + customer);

		rabbitTemplate.convertAndSend(CustomerConfig.EXCHANGE_NAME, CustomerConfig.ROUTING_KEY, customer);

		return customer;

	}
}
