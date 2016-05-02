<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login here</title>
</head>
<body>
<h2 align="center">Register Here </h2>

<font color="red" size="5"><html:errors property="login.invalid"/> </font>
	<html:form action="/RegSubmit">
		<br>
		<br>
		<table align="center" >
			<tbody>
				<tr>
					<td>Student ID :</td>
					<td><html:text property="sid"/></td>
					<td><font color=red size=5> <html:errors property="sid"/></font></td>
				</tr>
				<tr>
					<td>Age :<br>	</td>
					<td><html:text property="age"/></td>
					<td><font color="red" size="5"><html:errors property="age"/></font></td>
				</tr>
				
				<tr>
					<td>Fee paid :<br>	</td>
					<td><html:text property="feepaid"/></td>
					<td><font color="red" size="5"><html:errors property="feepaid"/></font></td>
				</tr>
				
				<tr>
					<td>Fee Bal :<br>	</td>
					<td><html:text property="feebal"/></td>
					<td><font color="red" size="5"><html:errors property="feebal"/></font></td>
				</tr>

			</tbody>
		</table>
		<br>
		<center>
			<html:submit value="Register"></html:submit>
		</center>
			<br>
			<br>
		
	</html:form>

</body>
</html>