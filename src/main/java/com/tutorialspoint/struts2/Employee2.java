package com.tutorialspoint.struts2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Example of the validation to occurr via the Employee2-validation.xml file.
 * @author jay
 *
 */
public class Employee2 extends ActionSupport{
	
   private String name;
   private int age;
   
   
   public String execute() 
   {
	   System.out.println("In execute of Employee2");
       return SUCCESS;
   }
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public int getAge() {
       return age;
   }
   public void setAge(int age) {
       this.age = age;
   }


}