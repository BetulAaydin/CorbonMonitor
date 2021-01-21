package com.corbonmonitor.repository;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_corbon_level")
public class SensorCorbonLevel {
	@Id
	@GeneratedValue
	private Long id;

	private Long sensor_def_id;
	
	private double trend_value;
	
	private double cycle_value;

	@Basic
	private java.sql.Timestamp time;

	@ManyToOne
	@JoinColumn(name = "sensor_def_id", insertable = false, updatable = false)
	private SensorDefinition sensorDefinition;

	public Long getSensor_def_id() {
		return sensor_def_id;
	}

	public void setSensor_def_id(Long sensor_def_id) {
		this.sensor_def_id = sensor_def_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTrend_value() {
		return trend_value;
	}

	public void setTrend_value(double trend_value) {
		this.trend_value = trend_value;
	}

	public double getCycle_value() {
		return cycle_value;
	}

	public void setCycle_value(double cycle_value) {
		this.cycle_value = cycle_value;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	public SensorDefinition getSensorDefinition() {
		return sensorDefinition;
	}

	public void setSensorDefinition(SensorDefinition sensorDefinition) {
		this.sensorDefinition = sensorDefinition;
	}
	
}
