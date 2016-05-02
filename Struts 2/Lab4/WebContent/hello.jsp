<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<s:head/>
</head>
<body>
<s:actionerror/>
<s:form action="HelloSubmit">
<s:textfield key="sname" />
<s:textfield key="email" />
<s:submit />
</s:form>
</body>
</html>