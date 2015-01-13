package io.pivotal.sensor.dao;

import io.pivotal.sensor.model.TiltSwitchEvent;

import org.springframework.data.repository.CrudRepository;


public interface TiltSwitchEventSensorRepository extends CrudRepository<TiltSwitchEvent, String> {

	
	
}
