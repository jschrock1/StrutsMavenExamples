<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>Text Tag Example</title>
</head>
<body>
	
<s:i18n name="HelloText">
   <s:text name="name.success"/><br>
   <s:text name="name.xyz">Message doesn't exists</s:text><br>
   <s:text name="name.msg.param">
      <s:param >ZARA</s:param>
   </s:text>
</s:i18n>

</body>
</html>