<%@taglib uri="/struts-tags" prefix="s" %><html>
<head>	<s:head/>	</head>
<body>
<h1>OGNL Test</h1>

<s:form action="HelloSubmit">
<s:textfield name="name" label="Enter Name" />
<s:textfield name="email" label="Enter Email" />
<s:textfield name="phone" label="Enter Phone" />
<s:submit/>
</s:form>

</body>
</html>
