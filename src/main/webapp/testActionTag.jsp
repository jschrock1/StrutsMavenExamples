<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Test Action tag</title>
</head>
<body>
   <s:action name="rainbow" executeResult="true">
      Displaying testActoinTag.jsp  which will render hellow world jsp, then rainbow. jsp<br /><br />
   </s:action>
</body>
</html>