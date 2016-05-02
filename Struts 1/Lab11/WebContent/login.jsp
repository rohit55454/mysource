<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login here</title>
</head>
<body>
<h1 align="center"><font color="red"> ${EMSG }</font></h1>
	<html:form action="LoginSubmit">
		<br>
		<br>
		<table align="center" >
			<tbody>
				<tr>
					<td>User Name :</td>
					<td><html:text property="username"/></td>
					<td><html:errors property="username"/>
				</tr>
				<tr>
					<td>Password :<br>
					</td>
					<td><html:password redisplay="true" property="password"/></td>
					<td><html:errors property="password"/>
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