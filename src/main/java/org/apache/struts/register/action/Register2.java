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
public class Register2 extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Person personBean;

	public String execute() throws Exception {
		
		//call Service class to store personBean's state in database
		System.out.println("In execute of Register");
		return SUCCESS;
		
	}
	
	public void throwException() throws Exception {

		throw new Exception("Exception thrown from throwException");

	}
	
	
	public void throwNullPointerException() throws NullPointerException {

		System.out.println("In throwNullPointerException of Register");
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
