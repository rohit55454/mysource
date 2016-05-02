<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<body>
		<h1>Search Contact Form</h1>
		<font color="red" size="5">${NOT_FOUND}</font> <br/>
		<form:form action="searchContactSubmit.jlc" commandName="searchContactCommand">
			<table>
				<tr><td>Enter Email ID:	</td><td><form:input path="email" /></td></tr>
				<tr><td><font color="red" size="4"><form:errors path="email" /> </font></td></tr>
			</table>
			
			<input type="submit" value="Search" />
			
		</form:form>
		
	</body>
</html>