<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<s:head />
</head>
<body>
	<h1>Struts 2 interceptors Test</h1>
	<s:actionerror />
	<table width="50%">
		<tr><td>Username</td><td> <s:property value="userId" /></td></tr>
		<tr><td>Email Id</td><td> <s:property value="emailId" /></td></tr>
		<tr><td>Greeting</td><td> <s:property value="#session.Greeting" /></td></tr>
		<tr><td>JLC MSG</td><td>  <s:property value="#session.JLCMSG" /></td></tr>
	</table>

</body>
</html>