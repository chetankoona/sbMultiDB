package com.example.springbootapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootapp.fact.entity.Run;
import com.example.springbootapp.fact.repository.RunRepository;

@Service
public class RunService {
	
	@Autowired
	private RunRepository runRepository;
	
	public List<Run> getAllRuns() {
		List<Run> runs = new ArrayList<>();
		runRepository.findAll().forEach(runs::add);
		return runs;
	}

}
