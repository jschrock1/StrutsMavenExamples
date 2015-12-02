<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="bootstrap.css">
<link rel="stylesheet" href="main.css">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>	

<style type="text/css">
  label{
    color: black;
  }
</style>

<div class="jumbotron">
		<h1>A Wonderful Assortment of Struts Examples!</h1>
		<p>Built with Maven</p>
		<p>Styled with Bootstrap</p>
</div>


<div class="row1">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="well">
					<h4>Basic helloWorld .</h4>
					<s:form action="hello">
						<s:textfield label="Please enter your name." name="name" value="Jay" />
						<s:select name="type" label="Type of HelloWorld Test"
							list="{'basic','dumpSession'}" />
						<s:submit  align="left"></s:submit>
					</s:form>
				</div>
			</div>
				
			<div class="col-md-4">
				<div class="well">
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
						<s:submit value="Submit" align="left" />
					</s:form>
					<p><a href="register.jsp">Please register</a> for our prize drawing.</p>
				</div>
			</div>

			<div class="col-md-4">	
				<div class="well">
					<h4>Basic login Connects to MySQL Database.</h4>
					<s:form action="login" method="post" namespace="/">
						<s:textfield label="Please enter your name." value="scott"
							key="userId" theme="xhtml" />
						<s:textfield label="Please enter your Password." value="navy"
							key="password" theme="xhtml" />
						<s:submit value="Login"  align="left"></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- end of row 1--> 

<div class="row2">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="well">
					<h4>Login using getModel in action class</h4>
					<s:form action="login2" method="post" namespace="/">
						<s:textfield label="Login ID" key="userId" value="Jay" />
						<s:password label="Password" key="password" />
						<s:submit  align="left"></s:submit>
					</s:form>
				</div>
			</div>

			<div class="col-md-4">
				<div class="well">
					<h4>Login using my own interceptor class.</h4>
					<s:form action="login3" method="post" namespace="/">
						<s:textfield label="Please enter your name." value="userId"
							key="userId" />
						<s:textfield label="Please enter your Password." value="password"
							key="password" />
						<s:submit value="Login"  align="left"></s:submit>
					</s:form>
				</div>
			</div>

			<div class="col-md-4">
				<div class="well">
					<h4>Display ValueStack and Session.</h4>
					<s:form action="hello1">
						<s:textfield label="Please enter your name." key="name" value="Jay" />
						<s:textfield label="test type" key="type" value="dumpSession" />
						<s:submit  align="left"></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- end of row 2 -->
<div class="row3">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="well">
					<h4>Dummy action, displays jsp with no java action getting called</h4>
					<s:form action="searchForm" method="post" namespace="/">
						<s:submit value="Find Tutorials"  align="left"></s:submit>
					</s:form>
					<br />
				</div>
			</div>

			<div class="col-md-4">
				<div class="well">
					<h4>Upload a file.</h4>
					<s:form action="upload" method="post" enctype="multipart/form-data">
						<s:file label="Upload your file." key="myFile" />
						<s:submit value="Upload"  align="left"></s:submit>
					</s:form>
				</div>
			</div>

			<div class="col-md-4">
				<div class="well">
					<h4>Send an Email.</h4>
					<s:form action="emailer" method="post">
						<s:textfield label="From" value="jay.schrock@gmail.com" key="from" />
						<s:textfield label="To" value="jay.schrock@gmail.com" key="to" />
						<s:textfield label="Password" value="EJohn969" key="password" />
						<s:textfield label="Subject" value="My Test Subject" key="subject" />
						<s:textfield label="Body" value="My Test Body" key="body" />
						<s:submit  align="left"></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- end of row 3 -->

<div class="row4">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="well">
					<h4>Validation age must be 28 to 65 - action is empinfo</h4>
					<s:form action="empinfo" method="post">
						<s:textfield name="name" label="Name" size="20" />
						<s:textfield name="age" label="Age" size="20" />
						<s:submit name="Submit" align="left" label="Submit" />
					</s:form>
				</div>
			</div>
			<div class="col-md-4">
				<div class="well">
					<h4>Validation with xml file rather than validate method - action
						is empinfo2.</h4>
					<h4>Does NOT work yet, validation file not picked up.</h4>
					<s:form action="empinfo2" method="post">
						<s:textfield name="name" label="Name" size="20" />
						<s:textfield name="age" label="Age" size="20" />
						<s:submit name="Submit" align="left" label="Submit" />
					</s:form>
				</div>
			</div>
			<div class="col-md-4">
				<div class="well">
					<h4>
						<s:text
							name="global.heading, property files need to be under resources" />
					</h4>
					<s:url id="indexEN" namespace="/" action="locale">
						<s:param name="request_locale">en</s:param>
					</s:url>
					<s:url id="indexES" namespace="/" action="locale">
						<s:param name="request_locale">es</s:param>
					</s:url>
					<s:url id="indexFR" namespace="/" action="locale">
						<s:param name="request_locale">fr</s:param>
					</s:url>

					<s:a href="%{indexEN}">English</s:a>
					<s:a href="%{indexES}">Spanish</s:a>
					<s:a href="%{indexFR}">France</s:a>

					<s:form action="empinfo" method="post" namespace="/">
						<s:textfield name="name" key="global.name" size="20" />
						<s:textfield name="age" key="global.age" size="20" />
						<s:submit name="Submit" align="left" key="global.submit" />
					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- end of row 4 -->

<div class="row5">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="well">
					<h4>eException handling, This demonstrates how conversion is done
						with objects</h4>
					<s:form action="helloException" method="post">
						<s:submit  align="left"></s:submit>
					</s:form>
				</div>
			</div>

			<div class="col-md-4">
				<div class="well">
					<h4>Struts 2 list, collection, merging and appending of lists.</h4>
					<s:form action="employee" method="post">
						<s:submit  align="left"></s:submit>
					</s:form>
				

					<br />
				</div>
			</div>

			<div class="col-md-4">
				<div class="well">
					<h4>Action tag call action directly from jsp page.</h4>
					<s:form action="testActoinTag" method="post">
						<s:submit  align="left"></s:submit>
					</s:form>

				<br />
				</div>
			</div>
		</div>
	</div>
</div>

<!-- end of row 5 -->

<div class="row6">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="well">
					<h4>Include tag, bean tag and param tags</h4>
					<s:include value="counter.jsp" />
				</div>
			</div>

			<div class="col-md-4">
				<div class="well">
					<h4>property tag, set, push and property usage</h4>
					<s:form action="system" method="post">
					<s:submit  align="left"></s:submit>
					</s:form>
				</div>
			</div>

			<div class="col-md-4">
				<div class="well">
					<h4>Date Tags</h4>
					<s:form action="helloDate" method="post">
						<s:submit  align="left"></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- end of row 6 -->

<div class="row7">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
				<div class="well">
					<h4>Text Tags Uses HelloText.properties</h4>
					<s:form action="helloText" method="post">
						<s:submit  align="left"></s:submit>
					</s:form>
				</div>
			</div>

			<div class="col-md-3">
				<div class="well">
					<h4>Url Tags creates a URL that when clicked will call an action</h4>
					<s:url id="login" action="login.action" var="myurl">
						<s:param name="userId">scott</s:param>
						<s:param name="password">navy</s:param>
					</s:url>

					<a href='<s:property value="#myurl" escape="&amp;"/>'> <s:property
							value="#myurl" escape="&amp;" /></a>
				</div>
			</div>

			<div class="col-md-3">
				<div class="well">
					<h4>UI tag examples</h4>
					<s:form action="uiExample" method="post" namespace="/">
						<s:submit align="left"></s:submit>
					</s:form>
				</div>
			</div>

			<div class="col-md-3">
				<div class="well">
					<h4>Ajax tag examples</h4>
					<s:form action="autoCompleterAction" method="post" namespace="/">
						<s:submit align="left"></s:submit>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>