<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head> <s:head/> </head>
<body>

<font color="red" size="7"><s:text name="label.jlc.header" /> </font>
<h3>Student Search Form</h3>

<font color="red" size="5">${exception.message } </font>
<s:form action="BidSearchSubmit" >
<s:textfield name="bid" label="Enter Batch ID" />
<s:submit value="Search">
</s:submit>
</s:form>
</body>
</html>