package org.koushik.javabrains.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	
	@Id @GeneratedValue @Column(name="ACCOUNT_ID")
	private int accountId;
	
	@Column(name="ACCOUNT_NAME")
	private String accountName;
	
	@Column(name="PROFITS_NAME")
	private Double profits;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails user;


	public Account() {}
	
	public Account(String name, Double profits) {
		this.accountName = name;
		this.profits = profits;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getProfits() {
		return profits;
	}

	public void setProfits(Double profits) {
		this.profits = profits;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	
	
}
