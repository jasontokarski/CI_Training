package com.capgemini.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Customer;

@RestController
public class HomeController {
	
	@PostMapping("/createWallet")
	public ResponseEntity<?> create(@RequestBody Customer customer) {
		
	}
}
