package io.pivotal.sensor.dao;

import io.pivotal.sensor.model.RFID;

import org.springframework.data.repository.CrudRepository;


public interface RFIDRepository extends CrudRepository<RFID, String> {

	RFID findByRfid(String rfid);
	
}
