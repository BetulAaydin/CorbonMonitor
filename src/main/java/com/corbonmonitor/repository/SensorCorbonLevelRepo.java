package com.corbonmonitor.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SensorCorbonLevelRepo  extends JpaRepository<SensorCorbonLevel, Long>{

	  @Query("SELECT sensorLevel FROM " +
		      "SensorCorbonLevel sensorLevel, " +
		      "SensorDefinition sensorDef, SensorRoles roles"
		      + " WHERE "
		     + "sensorLevel.sensor_def_id = sensorDef.id " +
		      "AND sensorDef.id= roles.sensor_def_id " +
		      "AND roles.role in (:sensorRoles) and sensorLevel.time between :startDate and :endDate order by sensorLevel.time")
		  List<SensorCorbonLevel> reriveSensorCorbonConcentrationBetweenDate(@Param("sensorRoles") List<String> sensorRoles,@Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);
}
