package io.pivotal.sensor.service;

import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

public interface TiltSwitchSensorService {

	void saveTiltSwitchEvent(TiltSwitchEvent event);
	
	TiltSwitch getTileSwitchByTiltSwitchID(String tiltSwitchId);
}
