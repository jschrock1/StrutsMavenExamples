<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Employees</title>
</head>
<body>

	<!--    Example of Iterator Tag

Iterator tag
We are using the iterator tag to go through the employees list. 
We supply the "employees" property as the source to the iterator tag. 
In the body of the iterator tag, we now have access to the Employee object in the 
employees list. We print the name of the employee followed by their department.

Sort tag
First of all we declared the DepartmentComparator as a bean. 
We gave this bean a name deptComparator. Then we used the sort tag and specify 
the "employees" list as the source and the "deptComparator" as the comparator 
to use. Then, as per the previous example, we iterate the list and print the 
employees. As you can see from the output, this prints the list of employees 
sorted by department

Subset tag
The subset tag is used to get a sub set of the list or array. We have two 
flavours of subset tag. In the first example, we use the recrutimentDecider 
to get the list of employees who work for the recruitment department 
(please see the getRecruitmentDecider() method in Employee.java).

In the second example, we are not using any deciders but instead we are 
after elements 2 and 3 in the list. The subset tag takes in two parameters 
"count" and "start". "start" determines the starting point of the subset and 
the "count" determines the length of the subset.

-->

	<b>Example of Iterator Tag</b>
	<br />
	<s:iterator value="employees">
		<s:property value="name" /> , 
	<s:property value="department" />
		<br />
	</s:iterator>

	<br />
	<b>Employees sorted by Department</b>
	<br />

	<s:bean name="com.tutorialspoint.struts2.DepartmentComparator"
		var="deptComparator" />


	<!--  note deptComparator is defined above to be the bean of DepartmentComparator
      took me some time to figure that one out, lol.   -->

	<s:sort comparator="deptComparator" source="employees">
		<s:iterator>
			<s:property value="name" /> , 
      <s:property value="department" />
			<br />
		</s:iterator>
	</s:sort>

	<br />

	<b>SubSet Tag - Employees working in Recruitment department </b>
	<br />
	<s:subset decider="recruitmentDecider" source="employees">
		<s:iterator>
			<s:property value="name" /> , 
      <s:property value="department" />
			<br />
		</s:iterator>
	</s:subset>

	<br />

	<b>SubSet Tag - Employees 2 and 3 </b>
	<br />
	<s:subset start="1" count="2" source="employees">
		<s:iterator>
			<s:property value="name" /> , 
            <s:property value="department" />
			<br />
		</s:iterator>
	</s:subset>

	<br />

	<b>Employees and Contractors Merged together.</b>
	<br />
	<s:merge id="allemployees">
		<s:param value="employees" />
		<s:param value="contractors" />
	</s:merge>
	<s:iterator value="allemployees">
		<s:property value="name" />,
        <s:property value="department" />
		<br />
	</s:iterator>

	<br />

	<b>Employees and Contractors appended together</b>
	<br />
	<s:append id="allemployees">
		<s:param value="employees" />
		<s:param value="contractors" />
	</s:append>
	<s:iterator value="allemployees">
		<s:property value="name" />,
      <s:property value="department" />
		<br />
	</s:iterator>
</body>
</html>