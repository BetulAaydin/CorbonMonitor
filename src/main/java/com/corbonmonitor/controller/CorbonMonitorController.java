package com.corbonmonitor.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import com.corbonmonitor.repository.SensorDefinition;
import com.corbonmonitor.repository.SensorDefinitionRepo;
import com.corbonmonitor.services.FetchSensorCorbonConcentrationService;


@RestController
public class CorbonMonitorController {
	@Autowired
	private SensorDefinitionRepo sensorDefinitionRepo;
	

	
	@GetMapping(path = "/hello")
	public String helloWorld() {
			return "Hello World";
	}
	@RequestMapping("/info")
	public @ResponseBody String userInfo(Authentication authentication) {
		String msg = "";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
		     String role = authority.getAuthority();
                     msg+= authentication.getName()+", You have "+ role;
		}
		return msg;
	}
	
	
	@GetMapping("/sensors")
	public List<SensorDefinition> getAllSensorDefinitionRepo(){
		return sensorDefinitionRepo.findAll();
		//return todoService.findAll();
	}
	
	@RequestMapping("/sensor-co2")
	public @ResponseBody String retrieveCorbonConcentrationBySensor(Authentication authentication) {
		   List<String> grantedSensors = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority). 
			        collect(Collectors.toList()); 
	
		
	}
}
