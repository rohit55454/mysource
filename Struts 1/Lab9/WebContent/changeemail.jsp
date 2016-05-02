<%@  taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html><head><title>change mail here</title></head>

<body>
<h1>Change ur Mail</h1>
<html:form action="/ChangeEmailSubmit">
	<table align="center">
		<tr>
			<td>Current Email :</td>
			<td><html:text property="currentEmail"></html:text></td>
			<td><font color="red" size=5><html:errors property="currentEmail"/> </font></td>
		</tr>

		<tr>
			<td>New Email :</td>
			<td><html:text property="newEmail"></html:text></td>
			<td><font color="red" size=5><html:errors property="newEmail"/> </font></td>
		</tr>
		
		<tr><td><html:submit value="Change" /></td></tr>

	</table>

</html:form>

</body>
</html>