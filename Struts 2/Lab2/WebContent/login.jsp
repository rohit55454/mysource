<%@taglib uri="/struts-tags" prefix="s" %><html>
<html>
<head>
	<s:head/> </head>
</head>
<body>
<h1>Java Learning Center</h1>
<h3>Account Login</h3>
	<s:actionerror/>

<s:form action="annotatedLoginSubmit">
	<s:textfield name="username" label="Username" />
	<s:password name="password" label="Password" />
	<s:submit cssStyle="font-size:30, color=:red" />
</s:form>

</body>
</html>