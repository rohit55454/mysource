<html><body>
<c:import url="header.jsp">
<c:param name="companyName" value="Java Learnning center"/>
</c:import>

<h1>This is jdbc.jsp<br>
Hello !${param.stuName }<br>
You have selected ${param.couName }</h1>

<c:import url="footer.jsp">
<c:param name="companyName" value="Java Learnning center"/>
</c:import>



</body>
</html>