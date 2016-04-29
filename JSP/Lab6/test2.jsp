<html>
<head>
<title>Lab 6</title>
</head>

<body><h1>

<%@page import="com.jlc.Student" %>
Using usebean and other tags

<jsp:useBean id="ST" class="com.jlc.Student" scope="session"></jsp:useBean>
<jsp:setProperty property="sid" name="ST" value="88"/>
<jsp:setProperty property="name" name="ST" value="myname"/>
<jsp:setProperty property="phone" name="ST" value="7778889990"/>
<br>

Sid : 	<jsp:getProperty property="sid" name="ST"/><br>
Name : 	<jsp:getProperty property="name" name="ST"/><br>
Phone : <jsp:getProperty property="phone" name="ST"/>

</h1>

</body>
</html>