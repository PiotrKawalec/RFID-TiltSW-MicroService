package io.pivotal.sensor.service;

import io.pivotal.sensor.dao.TiltSwitchEventSensorRepository;
import io.pivotal.sensor.dao.TiltSwitchSensorRepository;
import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiltSwitchServiceImpl implements TiltSwitchSensorService {

	@Autowired
	private TiltSwitchEventSensorRepository eventRepository;
	@Autowired
	private TiltSwitchSensorRepository tiltSwitchSensorRepository;
	
	@Override
	public void saveTiltSwitchEvent(TiltSwitchEvent event) {
		eventRepository.save(event);
	}

	@Override
	public TiltSwitch getTileSwitchByTiltSwitchID(String tiltSwitchId) {
		return tiltSwitchSensorRepository.findByTiltSwitchId(tiltSwitchId);
	}

	
}
