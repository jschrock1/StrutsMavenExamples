<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<title>Hello World</title>
<s:head />
<sx:head />
</head>
<body>
   <s:form>
      <sx:autocompleter label="Favourite Colour"
         list="{'red','green','blue'}" />
      <br />
      <sx:datetimepicker name="deliverydate" label="Delivery Date"
         displayFormat="dd/MM/yyyy" />
      <br />
     
      <br/>
      <sx:tabbedpanel id="tabContainer">
         <sx:div label="Tab 1">Tab 1</sx:div>
         <sx:div label="Tab 2">Tab 2</sx:div>
      </sx:tabbedpanel>
   </s:form>
</body>
</html>