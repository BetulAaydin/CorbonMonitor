package com.corbonmonitor;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.corbonmonitor.services.FetchSensorCorbonConcentrationService;


@SpringBootApplication
@EnableScheduling
public class CorbonMonitorApplication implements CommandLineRunner {
    @Autowired
    private FetchSensorCorbonConcentrationService fetchSensorCorbonConcentrationService;
	
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(CorbonMonitorApplication.class, args);
	
	}
	@PostConstruct
    void started() {
      TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
	 @Override
	    public void run(String... args) throws Exception {
		 fetchSensorCorbonConcentrationService.fetchSensorCorbonConcentration();
	    }
	 @Bean
	    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	       return builder.build();
	    }
	 

}
