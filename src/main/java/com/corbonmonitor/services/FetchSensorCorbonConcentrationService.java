package com.corbonmonitor.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;import org.springframework.stereotype.Service;

import com.corbonmonitor.repository.SensorCorbonLevel;
import com.corbonmonitor.repository.SensorCorbonLevelRepo;
import com.corbonmonitor.repository.SensorDefinitionRepo;




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
			int max = 10000;
			Random r = new Random();
			Random cycle = new Random();		
		//Sendor spain
		for (int i=0;i<5;i++) {
			SensorCorbonLevel sensorLevel=new SensorCorbonLevel();
			int id = r.nextInt(max);
			sensorLevel.setId(Long.valueOf(id));
			sensorLevel.setSensorDefinition(sensorDefinition.findByName("SensorSpain"));
			sensorLevel.setSensor_def_id(sensorDefinition.findByName("SensorSpain").getId());
			sensorLevel.setCycle_value(cycle.nextDouble());
			sensorLevel.setTrend_value(cycle.nextDouble());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, id);
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
			sensorLevel.setTime(timestamp);
			sensorCorbonLevelRepo.save(sensorLevel);
		}
	  
	  }
	  
	 
}
