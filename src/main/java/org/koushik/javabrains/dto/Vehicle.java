package org.koushik.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle {
	
	@Id @GeneratedValue @Column(name="VEHICLE_ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_NAME")
	private String vehicalName;
	
	// Create an inverse relationship.
	//@JoinColumn(name="USER_ID")
	@ManyToMany(mappedBy="vehicle")  //tells hiberntae to not map but rather map with userDetails.vehicle object
	private Collection<UserDetails> userList = new ArrayList<UserDetails>();

	
	public Collection<UserDetails> getUserList() {
		return userList;
	}

	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}

	public Vehicle() {}
	
	public Vehicle(String in) {
		this.vehicalName = in;
	}
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicalName() {
		return vehicalName;
	}

	public void setVehicalName(String vehicalName) {
		this.vehicalName = vehicalName;
	}


	
	


}
