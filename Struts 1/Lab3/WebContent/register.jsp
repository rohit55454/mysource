<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
</head>
<body>	
<h1 align="center"><font color="green"><u> Registration Form </u></font> </h1>

<html:form action="/RegisterSubmit">
<table align="center">
<tr><td>Name : </td>	<td><html:text property="sname"/></td>	<td><html:errors property="sname" /> </td> </tr>

<tr><td>Email :</td>	<td><html:text property="email"/></td>	<td><html:errors property="email" /> </td></tr>

<tr><td>Phone : </td>	<td><html:text property="phone" /></td>	<td><html:errors property="phone" /> </td></tr>

<tr><td>Gender : </td>	<td><html:radio value="Female" property="gender" /> Male <br>
							<html:radio value="Male" property="gender" /> Female</td>	<td><html:errors property="gender" /> </td> </tr>

<tr> <td>Course : </td>	<td><html:checkbox value="Module-1" property="course" />Module-1<br>
							<html:checkbox value="Module-2" property="course" />Module-2<br>
							<html:checkbox value="Module-3" property="course" />Module-3	</td><td><html:errors property="course" /> </td></tr>
								
<tr><td>Timings : </td>	<td><html:select property="timings"	>	<html:option value="">---- SELECT ----</html:option><br>
																<html:option value="7-9">7-9</html:option><br>
																<html:option value="9-11">9-11</html:option><br>
																<html:option value="11-1">11-1</html:option><br>	</html:select></td>
						<td><html:errors property="timings"/></td></tr>					

<tr><td>Remarks : </td>	<td><html:textarea property="remarks" /> </td>	<td><html:errors property="remarks" /> </tr>

<tr><td><html:submit value="Submit" /></td></tr>

</table>
</html:form>
</body>
</html>