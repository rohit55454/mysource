<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login here</title>
</head>
<body>
<form action="LoginSubmit.jlc" method="post">

<table align="center">
	<tr><td align="center"><font color="red" size="5">${EMSG}</font></td></tr>
	<tr><td colspan="3"><font size="6" color="green"> Account Login</font></td></tr>
	<tr><td><font size="3"> Enter Username : </font></td>
		<td><input type="text" name="username"/></td>
		<td><font color="red" size="3">${UN_ERR }</font></td></tr>
	<tr><td>Enter Password : </td>
		<td><input type="password" name="password"/></td>
		<td><font color="red" size="3">${PW_ERR }</font></td></tr>
	<tr><td align="right"><input type="submit" value="login"/></td></tr>
	

</table>
</form>
</body>
</html>