package com.tutorialspoint.struts2;

import org.koushik.javabrains.action.BaseAction;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Demonstrates an exception, we need to handle it, we have an exception
 * interceptor which should display the errorException.jsp  I've trie 
 * to rid this class up where it sets a member variable to the exception
 * message so that we can display that message on the browser, however
 * I found that after the exception the interceptor does not grab the value
 * so its unavailable, oh well, not a big problem, log files are where 
 * to place this info.  Perhaps we can create an action class to read a 
 * log file and display the exception stack....
 * 
 * @author jay
 *
 */
public class HelloException   extends ActionSupport  {
	
	public String exceptionStr;
	
	public void validate() {
		System.out.println("in validate of HelloException");
	}
	
	public String execute() throws Exception  {

		System.out.println("in execute() of HelloException");

		try {
		String str = null;
		if (str.equals("")) {
			exceptionStr = null;
			return SUCCESS;
		}
		return SUCCESS;
		} catch (NullPointerException e) {
			exceptionStr = (e.toString());  // this is not available to valueStack.  bummer
			System.out.println("Setting exception in execute: " + exceptionStr);
			throw new NullPointerException(e.getMessage());
		}

	}

	public String getExceptionStr() {
		System.out.println("Setting getExceptionStr");
		return exceptionStr;
	}

	public void setExceptionStr(String exceptionStr) {
		System.out.println("Setting exception");
		this.exceptionStr = exceptionStr;
	}

}
