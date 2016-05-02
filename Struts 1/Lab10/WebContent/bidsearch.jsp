<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>	<head>
	<title>Error Demo</title>	</head>
<body>
<h1>Student Search Form</h1>
<html:form action="/BidSubmit">
<table>
	<tr><td>Enter Batch ID : </td>	<td><html:text property="bid"/>	</td> 
		<td><font color="red" size="5"><html:errors property="bid"/> </font></td>	</tr>
	
	<tr><td><html:submit value="Search" /> </td></tr>

</table>
</html:form>
</body>
</html>