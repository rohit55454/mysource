<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<s:head />
</head>
<body>
	<center>
		<h1>Struts 2 interceptors Test</h1>
		<s:actionerror />
		<s:form action="TestAction">
			<table width="50%">
				<tr><td><s:textfield name="username" label="Username :" /></td></tr>
				<tr><td><s:textfield name="password" label="Password :" /></td></tr>
				<tr><td><s:submit /></td></tr>
			</table>

		</s:form>

	</center>

</body>
</html>