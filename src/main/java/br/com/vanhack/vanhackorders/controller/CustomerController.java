package br.com.vanhack.vanhackorders.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.vanhackorders.dto.CustomerDto;
import br.com.vanhack.vanhackorders.service.ICustomerService;
import br.com.vanhack.vanhackorders.service.exception.BusinessException;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/Customer") 
	public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDto customer) {
		try {
			String jwtToken = customerService.save(customer);
			return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
}
