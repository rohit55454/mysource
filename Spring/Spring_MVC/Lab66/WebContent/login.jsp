<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <html> 
  <body><center>
  	<h2>Login Here :</h2>
  	
  	<form:form method="post" commandName="user">
  		<table>
  			<tr>
  				<td> Username </td>
  				<td><form:input path="username" /> </td>
  				<td><font color="red" size="5"> <form:errors path="username" /> </font></td>
  			</tr>

			<tr>
  				<td> Password </td>
  				<td><form:password path="password" /> </td>
  				<td><font color="red" size="5"> <form:errors path="password" /> </font></td>
  			</tr>
			
			<br>
			<input type="submit" value="Account Login" />
	  		
  		</table>
  	
  	</form:form>
  	</center>
  </body>
</html>
