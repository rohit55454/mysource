<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab4</title>
</head>
<body>
<%! String str="Hello";
	void m1(){}  
%>
<h1>THIS IS SHOW JSP...</h1>
<%
	int a=99;
	out.println(a);
	System.out.println(a);
 %>
<br>
<%="Hello" %>


</body>
</html>