package org.koushik.javabrains.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * This is just my own helper class intended to put a log method
 * here so all classes can use it and avoid typing System.out.println.
 * As you can see not all classes inherit this, just a helper method
 * which when writing VetLink, these classes are typical and usually
 * filled with many common methods 
 * @author jay
 *
 */
public class BaseAction extends ActionSupport implements ModelDriven {

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void log(String str) {
		System.out.println(str);
	}

}
