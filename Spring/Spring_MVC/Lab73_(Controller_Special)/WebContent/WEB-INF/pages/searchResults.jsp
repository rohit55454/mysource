<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html> 
  <body>
  	
  	<h1>Search Results</h1><br>
  	
  	<c:if test="${EDIT eq 'FALSE' }">
  	<pre>
		First Name	: ${CTO.fname }
		Last Name	: ${CTO.lname }
		Email		: ${CTO.email }
		Phone		: ${CTO.phone }
	</pre>
	
	<a href="editContactSubmit.jlc"> Edit Contact </a>

  	</c:if>

	
	 <c:if test="${EDIT eq 'TRUE' }">
	 	<h2>Search Results</h2>
	 	<form:form action="updateContactSubmit.jlc" commandName="contactCommand">
	 	
	 		<table>
	 			<tr><td>First Name : </td>	<td><form:input path="fname" value="${CTO.fname }"/>
	 				<td><font color="red" size="5"><form:errors path="fname" /> </font></td></tr>
	 				
	 			<tr><td>Last Name : </td>	<td><form:input path="lname" value="${CTO.lname }"/>
	 				<td><font color="red" size="5"><form:errors path="lname" /> </font></td></tr>
	 				
	 			<tr><td>Email ID : </td>	<td><form:input path="email" value="${CTO.fname }"/>
	 				<td><font color="red" size="5"><form:errors path="email" /> </font></td></tr>
	 				
	 			<tr><td>Phone : </td>	<td><form:input path="phone" value="${CTO.fname }"/>
	 				<td><font color="red" size="5"><form:errors path="phone" /> </font></td></tr>
	 				
	 		</table>
	 		
	 		<input type="submit" value="Update Contact" />
	 		
	 	</form:form>
	 	
	 </c:if>








		

  </body>
</html>
