package com.tutorialspoint.struts2;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Action class to demonstrate how struts converts data from objects 
 * back to strings on your browser.
 * @author jay
 *
 */
public class SystemDetails extends ActionSupport {
	
	
   private Environment environment = new Environment("Development");
   private String operatingSystem = "Windows XP SP3";

   public String execute()
   {
      return SUCCESS;
   }
   public Environment getEnvironment() {
      return environment;
   }
   public void setEnvironment(Environment environment) {
      this.environment = environment;
   }
   public String getOperatingSystem() {
      return operatingSystem;
   }
   public void setOperatingSystem(String operatingSystem) {
      this.operatingSystem = operatingSystem;
   }
}