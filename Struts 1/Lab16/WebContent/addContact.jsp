<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html><head><title>Add COntact here</title></head>
<body>
<h1>Contact Management System</h1>
<html:form action="/AddContactSubmit">
<table>
<tr><td>First Name :</td>	<td><html:text property="fname" />	<td><html:errors property="fname"/></td></tr>
<tr><td>Last Name :</td>	<td><html:text property="lname" />	<td><html:errors property="lname"/></td></tr>
<tr><td>Email :</td>	<td><html:text property="email" />		<td><html:errors property="email"/></td></tr>
<tr><td>Phone :</td>	<td><html:text property="phone" />		<td><html:errors property="phone"/></td></tr>
<tr><td><html:submit value="Add Contact" /></td></tr>
</table>

</html:form>

<br><br><br>
<html:link forward="Home">Go Home Page</html:link>

</body>
</html>