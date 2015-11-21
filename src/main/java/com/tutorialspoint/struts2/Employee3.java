package com.tutorialspoint.struts2;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

/**
 * This class demonstrates the use of struts 2 tags relating to collection or
 * list of things. this class builds two lists, employee's and contractors. We
 * have a method called getRecruitmentDecider that returns a Decider object. The
 * Decider implementation returns true if the employee works for the recruitment
 * department, and it returns false otherwise.
 * 
 * @author jay
 *
 */

public class Employee3 {
	
	private String name;
	private String department;
	
	private List employees;
	private List contractors;

	public Employee3() {
	}

	public Employee3(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public String execute() {
		employees = new ArrayList();
		employees.add(new Employee3("George", "Recruitment"));
		employees.add(new Employee3("Danielle", "Accounts"));
		employees.add(new Employee3("Melissa", "Recruitment"));
		employees.add(new Employee3("Rose", "Accounts"));

		contractors = new ArrayList();
		contractors.add(new Employee3("Mindy", "Database"));
		contractors.add(new Employee3("Vanessa", "Network"));
		return "success";
	}

	public Decider getRecruitmentDecider() {
		return new Decider() {
			public boolean decide(Object element) throws Exception {
				Employee3 employee = (Employee3) element;
				return employee.getDepartment().equals("Recruitment");
			}
		};
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List getEmployees() {
		return employees;
	}

	public void setEmployees(List employees) {
		this.employees = employees;
	}

	public List getContractors() {
		return contractors;
	}

	public void setContractors(List contractors) {
		this.contractors = contractors;
	}
}