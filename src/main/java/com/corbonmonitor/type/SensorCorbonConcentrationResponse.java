package com.corbonmonitor.type;

import java.util.ArrayList;
import java.util.List;

public class SensorCorbonConcentrationResponse {
	private String sensorName;
	private List<SensorConcertrationDTO> co2=new ArrayList<SensorConcertrationDTO>();
	public String getSensorName() {
		return sensorName;
	}
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	public List<SensorConcertrationDTO> getCo2() {
		return co2;
	}
	public void setCo2(List<SensorConcertrationDTO> sensorConcertrationList) {
		co2 = sensorConcertrationList;
	}
	
}
