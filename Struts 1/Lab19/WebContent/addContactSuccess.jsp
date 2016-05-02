<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html><head><title>addContactSuccess.jsp</title></head>
<body>
<h2>Contact Mgmt System</h2>
<h3>Contact added Successfully</h3>

<table>
<tr><td>First Name : </td>	<td>${CTO.fname}</td></tr>
<tr><td>Last Name : </td>	<td>${CTO.lname}</td></tr>
<tr><td>Email : </td>	<td>${CTO.email}</td></tr>
<tr><td>Phone : </td>	<td>${CTO.phone}</td></tr>
</table>
<br><br><br>
<html:link forward="Home">Go Home Page</html:link>
</body>
</html>