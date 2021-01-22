package com.corbonmonitor.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
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

import com.corbonmonitor.repository.SensorCorbonLevel;
import com.corbonmonitor.repository.SensorCorbonLevelRepo;
import com.corbonmonitor.repository.SensorDefinition;
import com.corbonmonitor.repository.SensorDefinitionRepo;
import com.corbonmonitor.services.FetchSensorCorbonConcentrationService;

@RestController
public class CorbonMonitorController {
	@Autowired
	private SensorDefinitionRepo sensorDefinitionRepo;

	@Autowired
	private SensorCorbonLevelRepo sensorCorbonLevelRepo;

	@RequestMapping("/sensor-definition")
	public @ResponseBody String userInfo(Authentication authentication) {
		String msg = "";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			String role = authority.getAuthority();
			msg += authentication.getName() + ", You have " + role;
		}
		return msg;
	}

	@GetMapping("/sensors")
	public List<SensorDefinition> getAllSensorDefinitionRepo() {
		return sensorDefinitionRepo.findAll();
		// return todoService.findAll();
	}

	@GetMapping("/sensor-co2/{startdate}/{enddate}")
	public @ResponseBody List<SensorCorbonLevel> retrieveCorbonConcentrationBySensor(Authentication authentication,
			@PathVariable String startdate, @PathVariable String enddate) {
		List<String> grantedSensors = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.map(string -> string.split("ROLE_")[1]).collect(Collectors.toList());

		return sensorCorbonLevelRepo.reriveSensorCorbonConcentrationBetweenDate(grantedSensors,convertToTimestamp(startdate),convertToTimestamp(enddate));
	}

	private Timestamp convertToTimestamp(String timestampAsString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"	,Locale.ENGLISH);
		try {
			System.out.println(LocalDateTime.parse(timestampAsString, formatter));

		} catch (DateTimeParseException e) {
			System.out.println("Date format must be");
		}
		return Timestamp.valueOf(LocalDateTime.parse(timestampAsString, formatter));
	}
}
