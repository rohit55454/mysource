<%@taglib uri="/struts-tags" prefix="s" %><html>
<html>
<head>
	<s:head/> </head>
</head>
<body>
<s:text name="label.jlc.header" />
<h3>Account Login</h3>
	
<s:actionerror/>

<s:form action="annotatedLoginSubmit">
	<s:textfield name="username" label="Username" />
	<s:password name="password" label="Password" />
	<s:submit />
</s:form>

</body>
</html>