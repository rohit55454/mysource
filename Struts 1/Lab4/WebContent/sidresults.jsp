<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html> <head>
<title>Student Search Results</title> </head>

<body>
<h1>Search results</h1>
<table>
<tr><td>Student ID  :</td>	<td>${STO.sid}</td></tr>
<tr><td>Batch ID  :</td>	<td>${STO.bid}</td></tr>
<tr><td>Student Name  :</td>	<td>${STO.sname}</td></tr>
<tr><td>Email ID :</td>	<td>${STO.email}</td></tr>
<tr><td>Phone  :</td>	<td>${STO.phone}</td></tr>

</table>

</body>
</html>