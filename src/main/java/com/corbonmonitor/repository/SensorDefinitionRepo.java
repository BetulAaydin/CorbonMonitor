package com.corbonmonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface SensorDefinitionRepo extends JpaRepository<SensorDefinition, Long>{
	 SensorDefinition  findByName(String name);
}
