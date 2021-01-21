package com.corbonmonitor.repository;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_definition")
public class SensorDefinition {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String city;
	private String distirict;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistirict() {
		return distirict;
	}
	public void setDistirict(String distirict) {
		this.distirict = distirict;
	}
	
	
}
