<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
    <title>Welcome</title>
    <sx:head />
</head>
<body>
   <h4>Basic helloWorld with Tags and Action class.</h4>
	<!--  note in this example userName is never used in any action class -->
	<p><a href="<s:url action='hello'/>">Hello World</a></p>
	<s:url action="hello2" var="helloLink">
		<s:param name="userName">Bruce Phillips</s:param>
	</s:url>

	<p> <a href="${helloLink}">Hello Bruce Phillips</a> </p>

	<p>Get your own personal hello by filling out and submitting this form.</p>

	<s:form action="hello2">
		<s:textfield name="userName" label="Your name" />
		<s:submit value="Submit" />
	</s:form>
</body>
</html>