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
@Table(name = "RFID")
public class RFID {

	@Id
	@Column(name="RFID_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(name="RFID")
	private String rfid;
	private Date createdTime;
	private Boolean active;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rfid", orphanRemoval = true)
	private List<RFIDEvent> rfidEvents = new ArrayList<RFIDEvent>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<RFIDEvent> getRfidEvents() {
		return rfidEvents;
	}

	public void setRfidEvents(List<RFIDEvent> rfidEvents) {
		this.rfidEvents = rfidEvents;
	}

	
}
