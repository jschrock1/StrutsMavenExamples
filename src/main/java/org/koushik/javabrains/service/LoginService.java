package org.koushik.javabrains.service;

import org.koushik.javabrains.model.User;

public class LoginService {
	
	public LoginService() {
	}

	public boolean verifyLogin(User user) {
		return user.getUserId().equals("userId") && user.getPassword().equals("password");
	}
}
