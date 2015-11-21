package org.koushik.javabrains.model;

/**
 * A typical Java Bean class also called a PoJo class
 * @author jay
 *
 */
public class User {
	
	private String userId;
	private String password;
	
	
	public User() {
	}

	public String getUserId() {
		System.out.println("In getUserId: " + userId);
		return userId;
	}

	public void setUserId(String userId) {
		System.out.println("In setUserId: " + userId);
		this.userId = userId;
	}

	public String getPassword() {
		System.out.println("In getPassword: " + password);
		return password;
	}

	public void setPassword(String password) {
		System.out.println("In setPassword: " + password);
		this.password = password;
	}

}
