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
@Table(name = "TILT_SWITCH_EVENT")
public class TiltSwitchEvent {

	@Id
	@Column(name="TILT_SWITCH_EVENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private Boolean open;
	@ManyToOne
	@JoinColumn(name = "TILT_SWITCH_ID")
	private TiltSwitch tiltSwitch;
	private Date eventTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TiltSwitch getTiltSwitch() {
		return tiltSwitch;
	}
	public void setTiltSwitch(TiltSwitch tiltSwitch) {
		this.tiltSwitch = tiltSwitch;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	
}
