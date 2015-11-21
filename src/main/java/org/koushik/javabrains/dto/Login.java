package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id @GeneratedValue
	private int emailId;

	@Column(name="NAME")
	private String name;
	
	@Column(name="USSER_ID")
	private String userId;
	
	@Column(name="PASSWORD")
	private String password;
	
	public Login() {};
	
	public Login(String name, String userId, String password) {
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

}
