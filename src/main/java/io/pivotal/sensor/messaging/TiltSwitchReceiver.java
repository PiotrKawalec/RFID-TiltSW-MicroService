package io.pivotal.sensor.messaging;

import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;
import io.pivotal.sensor.service.TiltSwitchSensorService;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class TiltSwitchReceiver {

	@Autowired
	private TiltSwitchSensorService tiltSwitchSensorService;

	@HystrixCommand(fallbackMethod = "tiltDefaultFallback")
	public void receiveMessage(byte[] message) {
		// TODO need to work out message here!


		String msg = new String(message);
		String[] readings = msg.split(",");
		if (readings.length != 2) {
			// log error
			System.out.println("Message did not have the corect number of values!!! [" + msg + "]");
		} else {
			System.out.println("Received [" + msg + "]");
			// TODO
			// Get tilt sensor by its ID
			TiltSwitch ts = tiltSwitchSensorService.getTileSwitchByTiltSwitchID(readings[0]);
			if (ts != null) {// store event
			TiltSwitchEvent e = new TiltSwitchEvent();
			e.setEventTime(new Date());//TODO time should come from device, but this is a hack who cares :-) too much work to get device setup to get time from server
			//r.setSensorID(readings[0]);
			Integer sensorState = Integer.valueOf(readings[1]);
			if (sensorState == 1) {
				e.setOpen(true);
			} else {
				e.setOpen(false);
			}
			e.setTiltSwitch(ts);
			tiltSwitchSensorService.saveTiltSwitchEvent(e);
			} else {
				System.out.println("error no tilt switch found with ID : " + readings[0]);
			}
		}
	}
	
	public String tiltDefaultFallback(byte[] message) {
		System.out.println("Inside TILT-SWITCH, could not connect to DB");
        return "tilt fallback method";
	}

}
