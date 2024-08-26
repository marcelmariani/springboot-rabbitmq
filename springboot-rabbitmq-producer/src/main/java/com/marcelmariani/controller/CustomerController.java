package com.marcelmariani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelmariani.entity.Customer;
import com.marcelmariani.service.CustomerProducer;

@RestController
@RequestMapping("/message")
public class CustomerController {

	@Autowired
	CustomerProducer customerService;

	@PostMapping("send")
	public Customer postMessage(@RequestBody Customer customer) {
		return customerService.sendMessage(customer);
	}

}