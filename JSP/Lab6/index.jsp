<html>
<head>
<title>Lab 6</title>
</head>

<body>
<%@page import="com.jlc.Student" %>
<%
	Student st = new Student();
	st.setSid(99);
	st.setName("Sri");
	st.setPhone(9876543217L);
	session.setAttribute("STUD", st);
 %>
<hr>
<%
	Student s = (Student)session.getAttribute("STUD");
 %>

Sid : <%=s.getSid() %><br>
Name : <%=s.getName() %><br>
Phone : <%=s.getPhone() %>



</body>
</html>