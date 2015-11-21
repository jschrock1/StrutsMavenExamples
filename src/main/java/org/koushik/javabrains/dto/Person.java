package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Person {
	
	@Id @GeneratedValue @Column(name="PERSON_ID")
	private int personId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails user;
	

	public Person () {}
	
	public Person(String first, String last) {
		this.setFirstName(first);
		this.setLastName(last);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	public int getPersonId() {
		return personId;
	}	

	public void setPersonId(int personId) {
		this.personId = personId;
	}
		



}
