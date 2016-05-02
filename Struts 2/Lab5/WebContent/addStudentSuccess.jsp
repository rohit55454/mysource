<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head> <s:head/> </head>
<body>

<font color="red" size="7"><s:text name="label.jlc.header" /> </font>
<h3>Student Added Successfully</h3>

<table>
<tr> <td>Student Name : </td>	<td><s:property value="sname" /> </td></tr>
<tr> <td>Email : </td>	<td><s:property value="email" /> </td></tr>
<tr> <td>Phone : </td>	<td><s:property value="phone" /> </td></tr>
</table>

</body>
</html>