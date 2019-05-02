package com.example.springbootapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	
	@RequestMapping("/")
	public String displayString() {
		return "Application on openshift";
	}

}
