<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> <title>Home</title>  </head>
  
  <body>
	<h1>HOME PAGE</h1>
	<p>Anyone can view the Page</p>
	
	<p>	<a href="student/studenthome.jsp" >Secured Student Home Page</a></p>
	<p>	<a href="manager/managerhome.jsp" >Secured Manager Home Page</a></p>
	<p>	<a href="director/directorhome.jsp" >Secured Director Home Page</a></p>

  </body>
</html>
