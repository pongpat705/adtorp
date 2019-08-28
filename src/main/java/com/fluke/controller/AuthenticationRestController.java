package com.fluke.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fluke.security.AppAuthenticationProvider;

@RestController
@RequestMapping("/service")
public class AuthenticationRestController {

	@Autowired
	private AppAuthenticationProvider authenticationProvider ;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<String> authenticate(@RequestParam String username, @RequestParam String password, HttpSession session){
		
		
		SecurityContextHolder.getContext().setAuthentication(authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password)));
		
		return new ResponseEntity<String>(session.getId(), HttpStatus.OK);
	}
}
