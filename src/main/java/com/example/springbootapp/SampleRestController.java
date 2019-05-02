package com.example.springbootapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class SampleRestController {
	
	@Value("${propertyone}")
	private String propertyone;
	
	@RequestMapping("/")
	public String displayString() {
		return "Application on openshift "+ propertyone;
	}

}
