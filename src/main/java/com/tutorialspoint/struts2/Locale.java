package com.tutorialspoint.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class Locale extends ActionSupport{
	
   private String request_locale;	
	
   public String execute() 
   {
       return SUCCESS;
   }

public String getRequest_locale() {
	return request_locale;
}

public void setRequest_locale(String request_locale) {
	this.request_locale = request_locale;
}
}