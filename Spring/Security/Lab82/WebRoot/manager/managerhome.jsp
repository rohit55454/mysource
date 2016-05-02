<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html><body><center><br><h1> Manager Home Page <br/>This is protected Page<br/>
		You can see this page only if u are Director or Manager </h1></center>
<br>
<sec:authorize ifAllGranted="ROLE_DIRECTOR">You Have "ROLE_DIRECTOR</sec:authorize>
<br>
<sec:authorize ifAllGranted="ROLE_MANAGER">You Have "ROLE_MANAGER</sec:authorize>
<br>
<sec:authorize ifAllGranted="ROLE_STUDENT">You Have "ROLE_STUDENT</sec:authorize>

<br><br>
<sec:authentication property="name" />
<br>
<sec:authentication property="principal.username" />
<br>
<p><a href="../index.jsp">Home</a>
<p><a href="../j_spring_security_logout">Logout</a>




 </body> </html>