<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegStatus</title>
</head>
<body>
<h2> Registration completed Successfully....with the following info : <br><br>
<table>
	<tr><td>Name : </td>	<td>${regForm.sname}</td></tr>
	<tr><td>Email : </td>	<td>${regForm.email}</td></tr>
	<tr><td>phone : </td>	<td>${regForm.phone}</td></tr>
	<tr><td>Gender : </td>	<td>${regForm.gender}</td></tr>
	<tr><td>Courses : </td>	<td><logic:iterate id="cou" name="regForm" property="course" scope="session">
								<bean:write name="cou"/>
								</logic:iterate>			</td></tr>
								
	<tr><td>Timings : </td><td>${regForm.timings}</td></tr>
	<tr><td>Remarks : </td><td>${regForm.remarks}</td></tr>
								
</table>
</h2>
</body>
</html>