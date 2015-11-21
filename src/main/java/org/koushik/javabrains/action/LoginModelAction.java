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
public class LoginModelAction extends BaseAction  {

	private User user = new User();	

	public void validate() {
		log("In validate of LoginModelAction");
		if (StringUtils.isEmpty(user.getUserId())) {	
			log("In validate of LoginModelAction: userId is blank");
			addFieldError("userId", "User ID cannot be blank");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			log("In validate of LoginModelAction: password is blank");
			addFieldError("password", "Password cannot be blank");
		}
		log("Completed validate of LoginModelAction");
	}

	public String execute() {
		log("In execute of LoginModelAction user id is: " + user.getUserId());
		log("In execute of LoginModelAction password is: " + user.getPassword());
		try {
		   return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * The interceptor will call this to get the member variable.
	 */
	
	public User getModel() {	
		log("In getModel of LoginModelAction");
		return user;
	}

	protected void log(String str) {
		System.out.println(str);
	}

}
