package com.corbonmonitor.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.corbonmonitor.repository.SensorCorbonLevel;
import com.corbonmonitor.repository.SensorCorbonLevelRepo;
import com.corbonmonitor.repository.SensorDefinition;
import com.corbonmonitor.repository.SensorDefinitionRepo;
import com.corbonmonitor.type.SensorCorbonConcentrationResponse;




@Service
public class FetchSensorCorbonConcentrationService {
	@Autowired
	private SensorDefinitionRepo sensorDefinition;
	
	@Autowired
	private SensorCorbonLevelRepo sensorCorbonLevelRepo;
	 
	 /*We asume that the carbon concertrations will be collected from sensors for each 5 minutes,
	 the data may be processed to digital in different systems and this systems provide services to fetch them. */
	@Scheduled(fixedRate = 60000)  // every 30 seconds
	  public void fetchSensorCorbonConcentration() {		
			int max = 500;
			Random r = new Random();
			Random cycle = new Random();		
		//Sendor spain
		for (int i=0;i<5;i++) {
			SensorCorbonLevel sensorLevel=new SensorCorbonLevel();
			int id = r.nextInt(max);
			sensorLevel.setId(Long.valueOf(id));
			sensorLevel.setSensorDefinition(sensorDefinition.findByName("SensorSpain"));
			sensorLevel.setCycle_value(cycle.nextDouble());
			sensorLevel.setTrend_value(cycle.nextDouble());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis()+i);
			sensorLevel.setTime(timestamp);
			sensorCorbonLevelRepo.save(sensorLevel);
		}
	  
	  }
	  
	 
}
