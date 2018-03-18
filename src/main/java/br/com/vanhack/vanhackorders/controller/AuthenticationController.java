package br.com.vanhack.vanhackorders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.vanhackorders.security.Authentication;
import br.com.vanhack.vanhackorders.service.IAuthenticationService;
import br.com.vanhack.vanhackorders.service.exception.BusinessException;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

	@Autowired
	IAuthenticationService authenticationService;
	
	@PostMapping("/Customer/auth") 
	public ResponseEntity<String> authenticate(@RequestBody Authentication user)  {
		try {
			String jwtToken = authenticationService.authenticate(user);
			return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
