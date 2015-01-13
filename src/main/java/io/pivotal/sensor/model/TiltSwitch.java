package io.pivotal.sensor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TILT_SWITCH")
public class TiltSwitch {

	@Id
	@Column(name="TILT_SWITCH_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(name="TILTSWITCHID")
	private String tiltSwitchId;
	private Date createdTime;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tiltSwitch", orphanRemoval = true)
	private List<TiltSwitchEvent> tiltSwitchEvents = new ArrayList<TiltSwitchEvent>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTiltSwitchId() {
		return tiltSwitchId;
	}
	public void setTiltSwitchId(String tiltSwitchId) {
		this.tiltSwitchId = tiltSwitchId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public List<TiltSwitchEvent> getTiltSwitchEvents() {
		return tiltSwitchEvents;
	}
	public void setTiltSwitchEvents(List<TiltSwitchEvent> tiltSwitchEvents) {
		this.tiltSwitchEvents = tiltSwitchEvents;
	}
	
}
