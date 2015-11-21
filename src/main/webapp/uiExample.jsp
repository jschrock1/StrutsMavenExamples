<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
	<h4>Ui tags</h4>

	<h5>Example of Generator Tag, The colours of rainbow:</h5>

	<s:generator
		val="%{'Violet,Indigo,Blue,
         Green,Yellow,Orange,Red '}"
		count="7" separator=",">
		<s:iterator>
			<s:property />
			<br />
		</s:iterator>
	</s:generator>
	

<h4>Email Form</h4>
	<s:div>Email Form</s:div>
	<s:text name="Please fill in the form below:" />
	<s:form action="hello" method="post" enctype="multipart/form-data">
		<s:hidden name="secret" value="abracadabra" />
		<s:textfield key="email.from" name="from" />
		<s:password key="email.password" name="password" />
		<s:textfield key="email.to" name="to" />
		<s:textfield key="email.subject" name="subject" />
		<s:textarea key="email.body" name="email.body" />
		<s:label for="attachment" value="Attachment" />
		<s:file name="attachment" accept="text/html,text/plain" />
		<s:token />
		<!--  s:submit key="submit" / -->
	</s:form>


	<h4>Group Ui tags</h4>
	<s:form action="hello.action">
		<s:radio label="Gender" name="gender" list="{'male','female'}" />
		<s:checkboxlist label="Hobbies" name="hobbies"
			list="{'sports','tv','shopping'}" />
	</s:form>

	<h4>Example Ui tags</h4>
	<s:form action="login.action">
		<s:select name="username" label="Username"
			list="{'Mike','John','Smith'}" />

		<s:select label="Company Office" name="mySelection"
			value="%{'America'}" list="%{#{'America':'America'}}">
			<s:optgroup label="Asia" list="%{#{'India':'India','China':'China'}}" />
			<s:optgroup label="Europe"
				list="%{#{'UK':'UK','Sweden':'Sweden','Italy':'Italy'}}" />
		</s:select>

		<s:combobox label="My Sign" name="mySign"
			list="#{'aries':'ariesy','capricorn':'capricornyy'}" headerKey="-1"
			headerValue="--- Please Select ---" emptyOption="true"
			value="capricorn" />
		<s:doubleselect label="Occupation" name="occupation"
			list="{'Technical','Other'}" doubleName="occupations2"
			doubleList="top == 'Technical' ? 
         {'I.T', 'Hardware'} : {'Accounting', 'H.R'}" />

	</s:form>

	<h4>As you can see an exception occurs in the console, not sure
		yet how to fix it.</h4>

</body>
</html>