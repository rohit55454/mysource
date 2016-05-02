<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>
<head>
<title>Search Contact here</title>
</head>
<body>
<h2>Search Contact Form</h2>

<html:form action="/SearchContactSubmit" >
<table>
<tr><td>Enter Email :</td></tr>
<tr><td><html:text property="email" /></td></tr>
<tr><td><html:errors property="email" /></td></tr>

<tr><td><html:submit value="Show" /></td></tr>
</table>

</html:form>
</body>
</html>