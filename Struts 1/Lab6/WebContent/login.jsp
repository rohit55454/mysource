<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login here</title>
</head>
<body>
<h2 align="center">Login </h2>

<font color="red" size="5"><html:errors property="login.invalid"/> </font>
	<html:form action="/LoginSubmit">
		<br>
		<br>
		<table align="center" >
			<tbody>
				<tr>
					<td>User Name :</td>
					<td><html:text property="username"/></td>
					<td><font color=red size=5> <html:errors property="username"/></font></td>
				</tr>
				<tr>
					<td>Password :<br>
					</td>
					<td><html:password redisplay="true" property="password"/></td>
					<td><font color="red" size="5"><html:errors property="password"/></font></td>
				</tr>

			</tbody>
		</table>
		<br>
		<center>
			<html:submit value="Login"></html:submit>
		</center>
			<br>
			<br>
		
	</html:form>

</body>
</html>