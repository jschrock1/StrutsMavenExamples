package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Example of using a value object that is placed inside UserDetails.  Value objects have
 * no meaning by themselves, they are tied to another entity.  But we want to embed this
 * Department object inside User....  We are not attempting to create a separate relation
 * table for Department, must embed it into UserDetails  
 *
 * @author jay
 *
 */

@Embeddable
public class Department {
	
	@Column(name = "DEPARTMENT_NAME")
	private String deptName;


	public Department() {}
	
	public Department(String name) {
		this.deptName = name;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	

}
