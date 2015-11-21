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
<h2>Current Date</h2>

<h3>Day/Month/Year Format</h3>
<s:date name="currentDate" format="dd/MM/yyyy" />

<h3>Month/Day/Year Format</h3>
<s:date name="currentDate" format="MM/dd/yyyy" />
</body>
</html>