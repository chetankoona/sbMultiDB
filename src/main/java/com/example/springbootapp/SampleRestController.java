package com.example.springbootapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapp.dim.entity.Walk;
import com.example.springbootapp.fact.entity.Run;
import com.example.springbootapp.service.RunService;
import com.example.springbootapp.service.WalkService;

@RestController
public class SampleRestController {
	
	@Value("${propertyone}")
	private String propertyone;
	
	@Autowired
	private RunService runService;
	
	@Autowired
	private WalkService walkService;
	
	@RequestMapping("/runs")
	public List<Run> getRuns() {
		//return "Application on openshift "+ propertyone;
		return runService.getAllRuns();
	}
	
	@RequestMapping("/walks")
	public List<Walk> getWalks() {
		return walkService.getAllWalks();
	}
}
