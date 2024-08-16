package com.marcelmariani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelmariani.service.CustomerService;

@RestController
@RequestMapping("/message")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("send")
	public ResponseEntity<String> postMessage(@RequestBody String message) {
		customerService.sendMessage(message);
		return ResponseEntity.ok().body("Mensagem enviada com sucesso: " + message);
	}

}