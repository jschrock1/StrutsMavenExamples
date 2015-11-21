package com.tutorialspoint.struts2;

import java.util.Comparator;

public class DepartmentComparator implements Comparator {
	   
   public int compare(Object arg0, Object arg1) {
	   return ((Employee3)arg0).getDepartment().compareTo(((Employee3)arg1).getDepartment());
   }


}