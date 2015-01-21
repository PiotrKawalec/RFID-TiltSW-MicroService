package io.pivotal.sensor.dao;

import io.pivotal.sensor.model.RFIDEvent;

import org.springframework.data.repository.CrudRepository;


public interface RFIDSensorRepository extends CrudRepository<RFIDEvent, String> {

	
	
}
