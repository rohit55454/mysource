<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html> <head>
<title>Student Search Results</title> </head>

<body>
<h1><bean:message key="label.jlcheader"/> </h1><br>
<h1>Search results</h1>
<table>
<tr><td>Student ID  :</td>	
<td>Batch ID  :</td>	
<td>Student Name  :</td>
<td>Email ID :</td>	
<td>Phone  :</td>	

<logic:iterate id="STO" name="LIST" scope="request">
<tr>
<td>${STO.sid}</td>
<td>${STO.bid}</td>
<td>${STO.sname}</td>
<td>${STO.email}</td>
<td>${STO.phone}</td>

</tr>	
</logic:iterate>
</table>

</body>
</html>