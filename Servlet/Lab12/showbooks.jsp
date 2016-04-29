<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>show books jsp</title>
</head>
<body>
	<center>
		<h1>JLC Book Store</h1>
		<h2>Book Search</h2>
		<font color="green" size='6'> ${ADDED}</font>
	</center>
	<br>
<%	Object obj = request.getAttribute("MSG");
if(obj!=null){
%>
	<br>
	<center>
		<font color="red" size='6'><%=obj %></font> <br>
		<a href="index.jsp"><h2>GoTo Search Page</h2>
		</a>
	</center>
<%
}else{
	obj=session.getAttribute("BOOKS");
	ArrayList<String> blist = (ArrayList<String>)obj;
	for(String bnm : blist){
 %>
 <center>
 <form action="addtocart.jlc" method="post"><input type="hidden" name="bname" value="<%=bnm%>"/>
 <font size='5'><%=bnm%><input type="submit" value=" Add To Cart"> </font>
  </form>
</center>
 <% 
    }
 %>
<br/><br/><br/>
<center>
<form action="showcart.jlc"> <input type="submit" value="show cart"> </form>
</center>
<%}%>

</body>
</html>