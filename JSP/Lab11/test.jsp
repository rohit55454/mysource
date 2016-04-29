<html><body>
<c:import url="header.jsp">
<c:param name="companyName" value="Java learning Center"/>
</c:import>
<form action="home.jsp" method="post">
<h2>Enter Course Name : </h2>
<input type="text" name="courseName"/>
<h2>Enter Student Name : </h2>
<input type="text" name="studentname"/>
<input type="submit" value="Submit"/>
</form>
<c:import url="footer.jsp">
<c:param name="companyName" value="Java Learning Center"/>
</c:import>

</body>
</html>