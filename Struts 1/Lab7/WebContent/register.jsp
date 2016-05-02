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
					<td>Student Name :</td>
					<td><html:text property="sname"/></td>
					<td><font color=red size=5> <html:errors property="sname"/></font></td>
				</tr>
				<tr>
					<td>Email :<br>	</td>
					<td><html:text property="email"/></td>
					<td><font color="red" size="5"><html:errors property="email"/></font></td>
				</tr>
				
				<tr>
					<td>DOB [DD/MM/YYYY] :<br>	</td>
					<td><html:text property="dob"/></td>
					<td><font color="red" size="5"><html:errors property="dob"/></font></td>
				</tr>
				
				<tr>
					<td>DOR [DD/MM/YYYY] :<br>	</td>
					<td><html:text property="dor"/></td>
					<td><font color="red" size="5"><html:errors property="dor"/></font></td>
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