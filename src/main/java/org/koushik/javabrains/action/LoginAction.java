package org.koushik.javabrains.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.PrintStream;
import org.apache.commons.lang3.StringUtils;
import org.koushik.javabrains.model.User;

/**
 * This class demonstrates how struts converts between objects (User object in
 * this case) We inherit from BaseAction which is our class but it inherits from
 * ModelDriven and then we implement getModel which returns the User objects.
 * Then struts will simply call getter and setter methods on that object.
 * 
 * @author jay
 *
 */
public class LoginAction extends ActionSupport  {

	private String userId;
	private String password;

	public void setPassword(String password) {
		log("In setPassword");
		this.password = password;
	}

	//private User user = new User();
	

	public void validate() {
		log("In validate of LoginAction");
		//if (StringUtils.isEmpty(user.getUserId())) {
	    if (StringUtils.isEmpty(userId)) {	
			log("In validate of LoginAction: userId is blank");
			addFieldError("userId", "User ID cannot be blank");
		}
		//if (StringUtils.isEmpty(user.getPassword())) {
	    if (StringUtils.isEmpty(password)) {
			log("In validate of LoginAction: password is blank");
			addFieldError("password", "Password cannot be blank");
		}
		log("Completed validate of LoginAction");
	}

	public String execute() {
		log("In execute of LoginAction user id is: " + userId);
		try {
			//if (user.getUserId().equals("userId") && user.getPassword().equals("password")) {
		    if (userId.equals("userId") && password.equals("password")) {
				log("In execute of LoginAction userid and password matches");
				return "success";
			} else {
				log("In execute of LoginAction");
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	//public User getModel() {
	//	log("In getModel of LoginAction");
	//	return user;
	//}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		log("In setUserId");
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}	

	protected void log(String str) {
		System.out.println(str);
	}

}
