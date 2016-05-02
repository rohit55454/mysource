<%@taglib uri="/struts-tags" prefix="s" %><html>
<html>
<head><title>success.jsp</title>
	<s:head/> </head>
</head>
<body>
<h1>Java Learning Center</h1>

<h3>OGNL TEST</h3>
<h3>Action class Variables --	simple types</h3>

<table>
<tr><td>Name : </td>	<td><s:property value="user.name" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="user.email" /></td></tr>  
<tr><td>Phone : </td>	<td><s:property value="phone" /></td></tr>  
<tr><td>var X : </td>	<td><s:property value="user.x" /></td></tr>  
</table>

<h3>Request Attributes --	simple types</h3>

<table>
<tr><td>Name : </td>	<td><s:property value="#request.UNAME" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="#request.EMAIL" /></td></tr>  
</table>


<h3>Session Attributes --	simple types</h3>

<table>
<tr><td>Name : </td>	<td><s:property value="#session.UNAME" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="#session.EMAIL" /></td></tr>  
</table>


<h3>Application Attributes --	simple types</h3>

<table>
<tr><td>Name : </td>	<td><s:property value="#application.UNAME" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="#application.EMAIL" /></td></tr>  
</table>


<h3>Action class Variables --	user-Defined types</h3>

<table>
<tr><td>Bid : </td>	<td><s:property value="sto.bid" /></td></tr>  
<tr><td>Sid : </td>	<td><s:property value="sto.sid" /></td></tr>  
<tr><td>Sname : </td>	<td><s:property value="sto.sname" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="sto.email" /></td></tr>  
<tr><td>Phone : </td>	<td><s:property value="sto.phone" /></td></tr>  
<tr><td>City : </td>	<td><s:property value="sto.address.city" /></td></tr>  
<tr><td>State : </td>	<td><s:property value="sto.address.state" /></td></tr>  
<tr><td>Country : </td>	<td><s:property value="sto.address.country" /></td></tr>  

</table>


<h3>Request Attributes --	User-defined types</h3>

<table>
<tr><td>Bid : </td>	<td><s:property value="#request.STO.bid" /></td></tr>  
<tr><td>Sid : </td>	<td><s:property value="#request.STO.sid" /></td></tr>  
<tr><td>Sname : </td>	<td><s:property value="#request.STO.sname" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="#request.STO.email" /></td></tr>  
<tr><td>Phone : </td>	<td><s:property value="#request.STO.phone" /></td></tr>  
<tr><td>City : </td>	<td><s:property value="#request.STO.address.city" /></td></tr>  
<tr><td>State : </td>	<td><s:property value="#request.STO.address.state" /></td></tr>  
<tr><td>Country : </td>	<td><s:property value="#request.STO.address.country" /></td></tr>  
</table>



<h3>Session Attributes --	User-defined types</h3>

<table>
<tr><td>Bid : </td>	<td><s:property value="#session.STO.bid" /></td></tr>  
<tr><td>Sid : </td>	<td><s:property value="#session.STO.sid" /></td></tr>  
<tr><td>Sname : </td>	<td><s:property value="#session.STO.sname" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="#session.STO.email" /></td></tr>  
<tr><td>Phone : </td>	<td><s:property value="#session.STO.phone" /></td></tr>  
<tr><td>City : </td>	<td><s:property value="#session.STO.address.city" /></td></tr>  
<tr><td>State : </td>	<td><s:property value="#session.STO.address.state" /></td></tr>  
<tr><td>Country : </td>	<td><s:property value="#session.STO.address.country" /></td></tr>  
</table>


<h3>Session Attributes --	User-defined types</h3>

<table>
<tr><td>Bid : </td>	<td><s:property value="#session.STO.bid" /></td></tr>  
<tr><td>Sid : </td>	<td><s:property value="#session.STO.sid" /></td></tr>  
<tr><td>Sname : </td>	<td><s:property value="#session.STO.sname" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="#session.STO.email" /></td></tr>  
<tr><td>Phone : </td>	<td><s:property value="#session.STO.phone" /></td></tr>  
<tr><td>City : </td>	<td><s:property value="#session.STO.address.city" /></td></tr>  
<tr><td>State : </td>	<td><s:property value="#session.STO.address.state" /></td></tr>  
<tr><td>Country : </td>	<td><s:property value="#session.STO.address.country" /></td></tr>  
</table>


<h3>Application Attributes --	User-defined types</h3>

<table>
<tr><td>Bid : </td>	<td><s:property value="#application.STO.bid" /></td></tr>  
<tr><td>Sid : </td>	<td><s:property value="#application.STO.sid" /></td></tr>  
<tr><td>Sname : </td>	<td><s:property value="#application.STO.sname" /></td></tr>  
<tr><td>Email : </td>	<td><s:property value="#application.STO.email" /></td></tr>  
<tr><td>Phone : </td>	<td><s:property value="#application.STO.phone" /></td></tr>  
<tr><td>City : </td>	<td><s:property value="#application.STO.address.city" /></td></tr>  
<tr><td>State : </td>	<td><s:property value="#application.STO.address.state" /></td></tr>  
<tr><td>Country : </td>	<td><s:property value="#application.STO.address.country" /></td></tr>  
</table>


<h3>Action Class Variables -- Collection of simple types</h3>

<h3>Emails List : </h3>

<table>
<tr> <s:iterator id="em" value="emails"> <td> <s:property value="em"/></td>  </s:iterator>
</tr> 	
</table>


<h3>Request Attributes -- collection of simple types: </h3>
<h3>Emails List : </h3>
<table>
<tr> <s:iterator id="#request.EMAILS" value="emails"> <td> <s:property value="em"/></td>  </s:iterator>
</tr> 	
</table>



<h3>Session Attributes -- collection of simple types: </h3>
<h3>Emails List : </h3>
<table>
<tr> <s:iterator id="#session.EMAILS" value="emails"> <td> <s:property value="em"/></td>  </s:iterator>
</tr> 	
</table>



<h3>Application Attributes -- collection of simple types: </h3>
<h3>Emails List : </h3>
<table>
<tr> <s:iterator id="#application.EMAILS" value="emails"> <td> <s:property value="em"/></td>  </s:iterator>
</tr> 	
</table>



<h3>Action class Variables -- collection of user-defined types: </h3>
<h3>Students List : </h3>
<table>
<tr> <td> Student ID </td> <td>Batch ID </td> <td>Student Name</td> <td>Email ID</td> <td>Phone no.</td></tr> 	

<s:iterator id="sto" value="students">
<tr><td> <s:property value="sto.sid" /></td>
<tr><td> <s:property value="sto.bid" /></td>
<tr><td> <s:property value="sto.sname" /></td>
<tr><td> <s:property value="sto.email" /></td>
<tr><td> <s:property value="sto.phone" /></td>
</tr>
</s:iterator>
</table>


<h3>Students List :</h3>
<table>
<tr> <td> Student ID </td> <td>Batch ID </td> <td>Student Name</td> <td>Email ID</td> <td>Phone no.</td></tr> 	

<s:iterator id="sto" value="students">
<tr><td> <s:property value="sid" /></td>
<tr><td> <s:property value="bid" /></td>
<tr><td> <s:property value="sname" /></td>
<tr><td> <s:property value="email" /></td>
<tr><td> <s:property value="phone" /></td>
</tr>
</s:iterator>
</table>








</body>
</html>