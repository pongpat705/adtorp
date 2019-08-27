package com.fluke.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorRestController {

	@GetMapping("/403")
	public Map<String, String> notfound(){
		Map<String, String> result = new HashMap<>();
		result.put("message", "error");
		return result;
	}
}
