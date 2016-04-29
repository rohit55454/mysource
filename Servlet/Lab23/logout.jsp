<%@page session="false"  %>
<html><body>
<h1>Welcome</h1>
<tr><td><h1>Total Visits :<%=application.getAttribute("TV") %> </h1></td></tr>
<tr><td><h1>Total Active :<%=application.getAttribute("TA") %></h1></td></tr>
</table>
<br><br>
<h1>You have been logged out successfully...</h1>

Go to <a href="index.jsp">Home</a>

</body>

</html>