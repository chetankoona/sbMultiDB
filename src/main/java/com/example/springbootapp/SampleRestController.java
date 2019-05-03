package com.example.springbootapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	
	@Value("${propertyone}")
	private String propertyone;
	
	@Autowired
	private RunService runService;
	
	@RequestMapping("/")
	public List<Run> displayString() {
		//return "Application on openshift "+ propertyone;
		return runService.getAllRuns();
	}
}
