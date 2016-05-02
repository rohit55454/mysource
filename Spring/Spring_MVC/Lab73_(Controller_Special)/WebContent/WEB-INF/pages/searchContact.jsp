<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html> 
  <body>
  	
  	<h1>Search Contact</h1><br>
  	
	<form:form action="searchContactSubmit.jlc" commandName="searchContactCommand">
		enter email : <form:input path="email"/> <font color="red" size="5"><form:errors path="email" /> </font>
	<br>	
	<input type="submit" value="Search" />
	</form:form>  

  </body>
</html>
