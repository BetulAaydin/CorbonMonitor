package com.corbonmonitor.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.corbonmonitor.exception.DateFormatException;
import com.corbonmonitor.repository.SensorCorbonLevel;
import com.corbonmonitor.repository.SensorCorbonLevelRepo;
import com.corbonmonitor.repository.SensorDefinition;
import com.corbonmonitor.repository.SensorDefinitionRepo;
import com.corbonmonitor.services.FetchSensorCorbonConcentrationService;
import com.corbonmonitor.type.ResponseHeader;
import com.corbonmonitor.type.RetriveSensorLevelRequest;

@RestController
public class CorbonMonitorController {
	@Autowired
	private SensorDefinitionRepo sensorDefinitionRepo;

	@Autowired
	private SensorCorbonLevelRepo sensorCorbonLevelRepo;

	@RequestMapping("/roles")
	public @ResponseBody String userInfo(Authentication authentication) {
		String msg = "";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			String role = authority.getAuthority();
			msg += authentication.getName() + ", You have " + role;
		}
		return msg;
	}

	@GetMapping("/sensors")
	public ResponseHeader<List<SensorDefinition>> getAllSensorDefinitionRepo() {
		List<SensorDefinition> senorList= sensorDefinitionRepo.findAll();
		ResponseHeader<List<SensorDefinition>> responseheader=new ResponseHeader<List<SensorDefinition>>();
		responseheader.setResult_code(HttpStatus.OK.toString());
		if(senorList==null) {
			responseheader.setMessage("No Data");
			responseheader.setResult_code(HttpStatus.NO_CONTENT.toString());
		}
		responseheader.setContains(senorList);
		 return responseheader;
	}

	@GetMapping("/sensors/{id}")
	public ResponseHeader<SensorDefinition> getAllSensorDefinitionRepoById(@PathVariable Long id) {
		ResponseHeader<SensorDefinition> responseheader=new ResponseHeader<SensorDefinition>();
		responseheader.setResult_code(HttpStatus.OK.toString());
		Optional<SensorDefinition> sensorDefinition=sensorDefinitionRepo.findById(id);
		if(!sensorDefinition.isPresent()) {
			responseheader.setMessage("No Data");
			responseheader.setResult_code(HttpStatus.NO_CONTENT.toString());
		}
		responseheader.setContains(sensorDefinition.get());
		 return responseheader;
		// return todoService.findAll();
	}
	
	@PostMapping(path ="/sensor-co2", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseHeader<List<SensorCorbonLevel>> retrieveCorbonConcentrationBySensor(Authentication authentication,
			@RequestBody RetriveSensorLevelRequest retriveSensorLevelRequest) throws DateFormatException {
		List<String> grantedSensors = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.map(string -> string.split("ROLE_")[1]).collect(Collectors.toList());
        if(retriveSensorLevelRequest.getStartDate()==null||retriveSensorLevelRequest.getEndDate()==null) {
    		throw new DateFormatException("startdate and enddate are required");
        }
        if(convertToTimestamp(retriveSensorLevelRequest.getStartDate()).compareTo(convertToTimestamp(retriveSensorLevelRequest.getEndDate()))>0) {
    		throw new DateFormatException("startdate must be smaller than end date");
        }
        List<SensorCorbonLevel> sensorCorbonLevelList=sensorCorbonLevelRepo.reriveSensorCorbonConcentrationBetweenDate(grantedSensors,convertToTimestamp(retriveSensorLevelRequest.getStartDate()),convertToTimestamp(retriveSensorLevelRequest.getEndDate()));
        ResponseHeader<List<SensorCorbonLevel>> responseheader=new ResponseHeader<List<SensorCorbonLevel>>();
        responseheader.setContains(sensorCorbonLevelList);
        responseheader.setResult_code(HttpStatus.OK.toString());
		return responseheader;
	}

	private Timestamp convertToTimestamp(String timestampAsString) throws DateFormatException {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(""          
			   			                                 + "[yyyy-MM-dd HH:mm:ss]"
			   			                                 + "[yyyy-MM-dd HH:mm]"  
			   			                                 + "[yyyy-MM-dd]"
			   			                                 + "[yyyy-MM]", Locale.ENGLISH);
		            DateTimeFormatter DATEFORMATTER = new DateTimeFormatterBuilder().append(formatter)
				    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
				    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
				    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
				    .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
				    .toFormatter();
		try {
			System.out.println(LocalDateTime.parse(timestampAsString, DATEFORMATTER));
		} catch (DateTimeParseException e) {
			throw new DateFormatException("Date format must be yyyy-MM-dd HH:mm:ss");
		}
		return Timestamp.valueOf(LocalDateTime.parse(timestampAsString, formatter));
	}
}
