<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jlc" %>

 <html> 
  <body>
  	<h2>Course Info :</h2>
  	
  	<ul>
  		<jlc:forEach var="cou" items="${AL}">
  			<li><h1>${cou}</h1>
  		</jlc:forEach>
  	</ul>
  	
  </body>
</html>
