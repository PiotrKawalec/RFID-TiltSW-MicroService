package io.pivotal.sensor.messaging;

import io.pivotal.sensor.model.RFIDEvent;
import io.pivotal.sensor.service.RFIDSensorService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class RFIDReceiver {

	@Autowired
	private RFIDSensorService rfidSensorService;

	public void receiveMessage(byte[] message) {
		// TODO need to work out message here!


		String msg = new String(message);
		String[] readings = msg.split(",");
		if (readings.length != 3) {
			// log error
			System.out
					.println("Message did not have the corect number of values!!! ["
							+ msg + "]");
		} else {
			System.out.println("Received [" + msg + "]");
			// TODO
			// Get RFID based on rfid
			// store event
			// check if user/rfid is active
			// sent response back to arduino based on sensor id etc and get
			// arduino to verifiy sensorID and turn on green light :-)
			RFIDEvent r = new RFIDEvent();
			r.setEventTime(new Date());
			//r.setSensorID(readings[0]);
			r.setRfid(null);

			rfidSensorService.saveRFIDEvent(r);
		}
	}

}
