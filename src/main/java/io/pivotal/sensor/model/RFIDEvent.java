package io.pivotal.sensor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RFID_EVENT")
public class RFIDEvent {

	@Id
	@Column(name="RFID_EVENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@ManyToOne
	@JoinColumn(name = "RFID_ID")
	private RFID rfid;
	private Date eventTime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RFID getRfid() {
		return rfid;
	}

	public void setRfid(RFID rfid) {
		this.rfid = rfid;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	
}
