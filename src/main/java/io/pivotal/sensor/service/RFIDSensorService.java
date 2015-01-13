package io.pivotal.sensor.service;

import io.pivotal.sensor.model.RFIDEvent;

public interface RFIDSensorService {

	void saveRFIDEvent(RFIDEvent event);
	
}
