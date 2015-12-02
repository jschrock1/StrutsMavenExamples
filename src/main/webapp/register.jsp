<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>
</head>
<body>
	<h3>Register for a prize by completing this form.</h3>

	<s:form action="register">

		<s:textfield name="personBean.firstName" label="First name" />
		<s:textfield name="personBean.lastName" label="Last name" />
		<s:textfield name="personBean.email" label="Email" />
		<s:textfield name="personBean.age" label="Age" />
		<s:submit align="left" />
	</s:form>

	<p>
		<s:label> OR user global properties for register action called Register.properties</s:label>
		<s:label>The labels below come from Register.properties file</s:label>
	</P>

	<!--  The value for the key attribute instructs the Struts 2 framework to use the same value for the name 
		      attribute (personBean.firstName). For the label attribute's value the value of the key attribute is used 
		      by the Struts 2 framework to find a key in a properties file with the same value. So in our example, 
		      Struts 2 will look in Register.properties for a key with a value of personBean.firstName. The value of that 
		      key (First name) will be used as the label attribute's value. -->

	<s:form action="register">
		<s:textfield key="personBean.firstName" />
		<s:textfield key="personBean.lastName" />
		<s:textfield key="personBean.email" />
		<s:textfield key="personBean.age" />
		<s:submit align="left" />
	</s:form>

	<hr />
	<p>The following link comes from global.properties which is declared in struts.xml file and is avail to all action classes and jsp's</p>
	<s:text name="contact" />

</body>
</html>