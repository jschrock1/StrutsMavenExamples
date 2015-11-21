package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Email {
	
	@Id @GeneratedValue
	private int emailId;

	@Column(name="EMAIL_NAME")
	private String emailName;
	
	@Column(name="PASSWORD")
	private String password;
	
	
	public Email () {}
	
	public Email (String name, String password) {
		this.emailName = name;
		this.password = password;
	}

	public String getEmailName() {
		return emailName;
	}

	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
