package com.marcelmariani.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
	
	public static final String QUEUE_NAME  = "QueueCustomer";
	public static final String EXCHANGE_NAME = "ExchangeCustomer";
	public static final String ROUTING_KEY = "createCustomer";

//	@Bean
//	DirectExchange customerExchange() {
//		return new DirectExchange(EXCHANGE_NAME);
//	}
//
//	@Bean
//	Queue queue() {
//		return QueueBuilder.durable(QUEUE_NAME).build();
//	}
//
//	@Bean
//	Binding binding() {
//		return BindingBuilder.bind(queue()).to(customerExchange()).with(ROUTING_KEY);
//	}
}