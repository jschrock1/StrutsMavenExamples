<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>ERROR:  <s:property value="message" /></h4>
	 

	<s:form action="login" method="post">
		<s:textfield label="Please enter your name." value="scott"
			key="userId" theme="xhtml" />
		<s:textfield label="Please enter your Password." value="navy"
			key="password" theme="xhtml" />
		<s:submit value="Login"></s:submit>
	</s:form>
</body>
</html>