package io.pivotal.sensor.service;

import io.pivotal.sensor.dao.RFIDRepository;
import io.pivotal.sensor.dao.RFIDSensorRepository;
import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RFIDServiceImpl implements RFIDSensorService {

	@Autowired
	private RFIDSensorRepository rfidEventRepository;
	
	@Autowired
	private RFIDRepository rfidRepository;
	
	@Override
	public void saveRFIDEvent(RFIDEvent event) {
		rfidEventRepository.save(event);
	}

	@Override
	public RFID findByRFID(String rfid) {
		return rfidRepository.findByRfid(rfid);
	}
	
}
