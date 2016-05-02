<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html><head><title>Search Results</title></head>
<body>
<logic:equal name="EDIT" value="FALSE" scope="session">
<h2>Search Results :</h2>

<table>
<tr><td>First Name : </td>	<td>${CTO.fname }</td></tr>
<tr><td>Last Name : </td>	<td>${CTO.lname }</td></tr>
<tr><td>Email : </td>		<td>${CTO.email }</td></tr>
<tr><td>Phone : </td>		<td>${CTO.phone }</td></tr>
</table>

<html:form action="/EditContactSubmit?method=Edit Contact">
<html:submit value="Edit Contact" />
</html:form>
</logic:equal>
<logic:equal name="EDIT" value="TRUE" scope="session">
<html:form action="/UpdateContactSubmit?method=Update Contact">
<table>
<tr><td>First name :</td>	<td><html:text property="fname" value="${CTO.fname}" /></td>
							<td><html:errors property="fname"/></td></tr>
<tr><td>Last name :</td>	<td><html:text property="lname" value="${CTO.lname}" /></td>
							<td><html:errors property="lname"/></td></tr>
<tr><td>Email :</td>		<td><html:text property="email" value="${CTO.email}" /></td>
							<td><html:errors property="email"/></td></tr>
<tr><td>Phone :</td>		<td><html:text property="phone" value="${CTO.phone}" /></td>
							<td><html:errors property="phone"/></td></tr>
</table>

<html:submit value="Update Contact" />
</html:form>

</logic:equal>

<br><br><br>
<html:link forward="Home">Go Home Page</html:link>
</body>
</html>