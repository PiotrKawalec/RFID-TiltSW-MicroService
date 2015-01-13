package io.pivotal.sensor.service;

import io.pivotal.sensor.dao.RFIDSensorRepository;
import io.pivotal.sensor.model.RFIDEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RFIDServiceImpl implements RFIDSensorService {

	@Autowired
	private RFIDSensorRepository repository;
	
	@Override
	public void saveRFIDEvent(RFIDEvent event) {
		repository.save(event);
	}

	
}
