<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<body>
		<h2>Search Results</h2>
		
		<c:if test="${EDIT eq FALSE }">
			<table>
				<tr><td>Contact ID : </td> <td>${CTO.cid }</td></tr>
				<tr><td>First Name : </td> <td>${CTO.fname }</td></tr>
				<tr><td>Last Name : </td> <td>${CTO.lname }</td></tr>
				<tr><td>Email ID : </td> <td>${CTO.email }</td></tr>
				<tr><td>Phone No. : </td> <td>${CTO.phone }</td></tr>	
			</table>
			
			<b><a href="editContactSubmit.jlc"> Edit Contact</a></b>
		</c:if>
		
		<c:if test="${EDIT eq TRUE }">
			<form:form action="updateContactSubmit.jlc" commandName="contactCommand">
			<table>
				<tr><td>Contact ID : </td> <td>${CTO.cid }<form:hidden path="cid" value="${CTO.cid }"/> </td></tr>
				
				<tr><td>First Name : </td> <td><form:input path="fname" value="${CTO.fname }"/> </td>
					<td><font color="red" size="5"><form:errors path="fname"/></font></td></tr>
				
				<tr><td>Last Name : </td> <td><form:input path="lname" value="${CTO.lname }"/> </td>
					<td><font color="red" size="5"><form:errors path="lname"/></font></td></tr>
				
				<tr><td>Email ID : </td> <td><form:input path="email" value="${CTO.email}"/> </td>
					<td><font color="red" size="5"><form:errors path="fname"/></font></td></tr>
				
				<tr><td>Phone No. : </td> <td><form:input path="phone" value="${CTO.phone}"/> </td>
					<td><font color="red" size="5"><form:errors path="phone"/></font></td></tr>
				
			</table>
			
			<input type="submit" value="Update Contact">
			
			</form:form>
		</c:if>
		
	</body>
</html>