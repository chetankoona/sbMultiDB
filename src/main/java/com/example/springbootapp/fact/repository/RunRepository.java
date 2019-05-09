package com.example.springbootapp.fact.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootapp.fact.entity.Run;

public interface RunRepository extends CrudRepository<Run, Long> {

}
