package com.marcelmariani.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelmariani.config.CustomerConfig;
import com.marcelmariani.entity.Customer;

@Service
public class CustomerService {


	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
    
	public void sendMessage(String message) {
		
		logger.info("sendMessage -> " + String.format(message));

		var customer = new Customer("Paulo da Silva", "paulo@feltex.com.br", "2242-33441");
		rabbitTemplate
				.convertAndSend(CustomerConfig.EXCHANGE_NAME, CustomerConfig.ROUTING_KEY,
                customer);

	}


    public void produzirMensagem() {

    }
	
}
