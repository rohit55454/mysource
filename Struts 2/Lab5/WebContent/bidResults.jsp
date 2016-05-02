<%@taglib uri="/struts-tags" prefix="s"%><html>
<head> <s:head/> </head>
<body>

<font color="red" size="7"><s:text name="label.jlc.header" /> </font>
<h3>Student Search Results</h3>

<table>
<tr><td>Student ID </td> <td>Student Batch </td> <td>Student name </td> <td>Student email </td> <td>Student phone </td>	</tr>
<s:iterator value="students">
<tr><td><s:property value="sid"/></td>	<td><s:property value="bid"/></td>
	<td><s:property value="sname"/></td>	<td><s:property value="email"/></td>
	<td><s:property value="phone"/></td>
</tr>

</s:iterator>

</table>
</body></html>