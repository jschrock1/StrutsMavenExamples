package org.koushik.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class RentalCar {
	
	@Id @GeneratedValue @Column(name="RENTAL_ID")
	private int rentalId;
	
	@Column(name="RENTAL_COMPANY")
	private String rentalCompany;
	
	@Column(name="CAR")
	private String car;
		
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private UserDetails user;
	
	
	public RentalCar() {}
	
	public RentalCar(String company, String car) {
		this.rentalCompany = company;
		this.car = car;
	}

	public String getRentalCompany() {
		return rentalCompany;
	}

	public void setRentalCompany(String rentalCompany) {
		this.rentalCompany = rentalCompany;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
	

	
	

}
