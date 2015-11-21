package org.koushik.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * This example shows how to persist data from two sub classes inheriting from Vehicle3, and
 * this time the data will go into three separate tables.
 * @author jay
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  // mulitple tables
public class Vehicle3 {
	
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicalName;
	

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
