package com.corbonmonitor.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

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
	
	 @PostConstruct
	  void postConstruct(){
		 System.out.println("Call the fetchmethod first time when the project run");
		fetchSensorCorbonConcentration();
	  }
	 
	 /*We asume that the carbon concertrations will be collected from sensors for each 5 minutes,
	 the data may be processed to digital in different systems and this systems provide services to fetch them. */
	@Scheduled(fixedRate = 300000)  // every 30 seconds
	  public void fetchSensorCorbonConcentration() {	
		    this.generateDummyData("SensorSpain");	
			this.generateDummyData("SensorAustria");	
			this.generateDummyData("SensorGermany");		
	  }
	  
	 private void generateDummyData(String sensorName) {
			Random index = new Random(500);
			Random cycle = new Random();
			Calendar cal = Calendar.getInstance();
			cal.set(2021,01,01,8,0);	
		//Sendor spain
		for (int i=0;i<10;i++) {
			SensorCorbonLevel sensorLevel=new SensorCorbonLevel();
			String primarykey=String.valueOf(index.nextInt())+String.valueOf(i);
			sensorLevel.setId(Long.valueOf(primarykey));
			sensorLevel.setSensorDefinition(sensorDefinition.findByName(sensorName));
			sensorLevel.setSensor_def_id(sensorDefinition.findByName(sensorName).getId());
			sensorLevel.setCycle_value(cycle.nextDouble());
			sensorLevel.setTrend_value(cycle.nextDouble());
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
			sensorLevel.setTime(timestamp);
			cal.add(Calendar.MINUTE, i);
			sensorCorbonLevelRepo.save(sensorLevel);
		}
	 }
}
