package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@RequestMapping(value = "")
	public String greeting() {
		return "Welcome to Second micro service project running on port number 8081";
	}
}