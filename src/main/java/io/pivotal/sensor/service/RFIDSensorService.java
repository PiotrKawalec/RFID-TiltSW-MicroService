package io.pivotal.sensor.service;

import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;

public interface RFIDSensorService {

	void saveRFIDEvent(RFIDEvent event);
	
	RFID findByRFID(String rfid);
}
