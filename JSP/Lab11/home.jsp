<html>
<body>
	<h1>Hello Guys</h1>
	<%
		String str = "java, jdbc, servlet, jsp";
		request.setAttribute("STR", str);
	%>
	<c:forTokens items="${STR } delims=" ," var="c">
		<br>${c }</c:forTokens>
	<c:forEach begin="1" end="25" step="2" var="i">
		<br>${i }</c:forEach>
	<c:set var="CN" value="${param.courseName }" scope="session" />
	<c:choose>

		<c:when test="${CN eq 'java' }">
			<c:redirect url="java.jsp">
				<c:param name="stuName" value="${param.studentName }" />
				<c:param name="couName" value="${param.courseName }" />
			</c:redirect>
		</c:when>

		<c:when test="${CN eq 'jdbc' }">
			<c:redirect url="jdbc.jsp">
				<c:param name="stuName" value="${param.studentName }" />
				<c:param name="couName" value="${param.courseName }" />
			</c:redirect>
		</c:when>

		<c:otherwise>
			<c:redirect url="other.jsp">
				<c:param name="stuName" value="${param.studentName }" />
				<c:param name="couName" value="${param.courseName }" />
			</c:redirect>
		</c:otherwise>

	</c:choose>
</body>
</html>