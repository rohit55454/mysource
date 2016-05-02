<%@taglib uri="/struts-tags" prefix="s"%><html>
<head> <s:head/> </head>
<body>

<font color="red" size="7"><s:text name="label.jlc.header" /> </font>
<h3>Student Search Results</h3>

<table>
<tr><td>Student ID </td>	<td><s:property value="sto.bid" /> </td></tr>
<tr><td>Student name </td>	<td><s:property value="sto.sname" /> </td></tr>
<tr><td>Student email </td>	<td><s:property value="sto.email" /> </td></tr>
<tr><td>Student phone </td>	<td><s:property value="sto.phone" /> </td></tr>

</table>
</body></html>