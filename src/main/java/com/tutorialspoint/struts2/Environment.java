package com.tutorialspoint.struts2;

/**
 * This class is used to show how struts 2 converts complex types, 
 * strings and ints are easy, but sometimes member variables can 
 * be objects.  this has one string in it, name as member variable.
 * @author jay
 *
 */
public class Environment {
   private String name;
   public  Environment(String name)
   {
      this.name = name;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
}