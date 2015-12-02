<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>

	<s:if test="type=='basic'">
   Hello, <s:property value="name" />
		<br />
   Type, <s:property value="type" />
	</s:if>

	<s:if test="type=='dumpSession'">
		<h4>Showing ValueStack and Session info</h4>
         <s:property value="vsStr" />
		<br />
	     Session attributes are: <s:property value="mySession" />

	</s:if>




</body>
</html>