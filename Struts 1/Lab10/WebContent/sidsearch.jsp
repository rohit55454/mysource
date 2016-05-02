<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>	<head>
	<title>Exception Demo</title>	</head>
<body>
<h1>Student Search Form</h1>
<font color="red" size="5"> ${EMSG}</font>

<html:form action="/SidSubmit">

<table>
<tr><td>Enter Student : </td>	<td><html:text property="sid"/>	</td> 
	<td><font color="red" size="5"><html:errors/> </font></td>	</tr>

<tr><td><html:submit value="Search" /> </td></tr>

</table>
<html:javascript formName="sidSearchForm"/>

</html:form>
</body>
</html>