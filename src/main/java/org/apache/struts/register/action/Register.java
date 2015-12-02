package org.apache.struts.register.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts.register.exceptions.SecurityBreachException;
import org.apache.struts.register.model.Person;

/**
 * Acts as a controller to handle actions
 * related to registering a user.
 * @author bruce phillips
 *
 */
public class Register extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Person personBean;
	
	public void validate(){
	     
		System.out.println("In validate of Register");
		if (personBean.getFirstName().length() == 0) {

			addFieldError("personBean.firstName", "First name is required.");

		}

		if (personBean.getEmail().length() == 0) {

			addFieldError("personBean.email", "Email is required.");

		}

		if (personBean.getAge() < 18) {

			addFieldError("personBean.age", "Age is required and must be 18 or older");

		}
	     
	     
	}


	public String execute() throws Exception {
		
		//call Service class to store personBean's state in database
		System.out.println("In execute of Register");
		return SUCCESS;
		
	}
	
	public void throwNullPointerException() throws NullPointerException {

		throw new NullPointerException("Null Pointer Exception thrown from "
				+ Register.class.toString());
	}

	public void throwSecurityException() throws SecurityBreachException {

		System.out.println("In throwSecurityException of Register");
		throw new SecurityBreachException(
				"Security breach exception thrown from throwSecurityException");
	}
	
	public Person getPersonBean() {
		
		return personBean;
		
	}
	
	public void setPersonBean(Person person) {
		
		personBean = person;
		
	}

}
