package com.corbonmonitor.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_roles")
public class SensorRoles {
	@Id
	@GeneratedValue
	private Long id;
	
	private String role;
	
	private Long sensor_def_id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getSensor_def_id() {
		return sensor_def_id;
	}

	public void setSensor_def_id(Long sensor_def_id) {
		this.sensor_def_id = sensor_def_id;
	}
}