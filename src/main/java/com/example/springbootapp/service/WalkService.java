package com.example.springbootapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootapp.dim.entity.Walk;
import com.example.springbootapp.dim.repository.WalkRepository;

@Service
public class WalkService {
	
	@Autowired
	private WalkRepository walkRepository;
	
	public List<Walk> getAllWalks() {
		List<Walk> walks = new ArrayList<>();
		walkRepository.findAll().forEach(walks::add);
		return walks;
	}

}
