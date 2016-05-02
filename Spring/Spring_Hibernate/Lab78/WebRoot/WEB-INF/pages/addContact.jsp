<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<body>
		<h2>Add Contact Form</h2>
		<form:form action="addContactSubmit.jlc" commandName="contactCommand" >
			<table>
				<tr><td>First Name : </td>	<td><form:input path="fname"/></td>
					<td><font color="red" size="5"> <form:errors path="fname" /> </font></td></tr>
				
				<tr><td>Last Name : </td>	<td><form:input path="lname"/></td>
					<td><font color="red" size="5"> <form:errors path="lname" /> </font></td></tr>
				
				<tr><td>Email : </td>	<td><form:input path="email"/></td>
					<td><font color="red" size="5"> <form:errors path="email" /> </font></td></tr>
				
				<tr><td>Phone : </td>	<td><form:input path="phone"/></td>
					<td><font color="red" size="5"> <form:errors path="phone" /> </font></td></tr>
				
			</table>		
			
			<input type="submit" value="Add Contact" />
			
		</form:form>
	</body>
</html>