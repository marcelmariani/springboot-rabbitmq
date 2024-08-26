package com.marcelmariani.component;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.marcelmariani.config.CustomerConfig;
import com.marcelmariani.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomerConsumer {

	@RabbitListener(
			bindings = @QueueBinding(value = @Queue(CustomerConfig.QUEUE_NAME), 
			exchange = @Exchange(name = CustomerConfig.EXCHANGE_NAME), 
			key = CustomerConfig.ROUTING_KEY))

	public void readMessage(final Customer customer) {
		
		log.info("Reading Customer{}", customer);
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
