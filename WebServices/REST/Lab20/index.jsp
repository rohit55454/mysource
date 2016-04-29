<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<h1>
		<br/> Result of Request <hr/> <br>
		<c:if test="${STUD ne null }">
			Student ID : ${STUD.sid } <br> Student name :${STUD.name }<br>
			Student Phone : ${STUD.phone }<br>
		</c:if>
		
		<c:if test="${ADDED ne null }">${ADDED }</c:if>
		<c:if test="${LIST ne null }">
			<table border='2' width='75%'>
				<tr bgcolor="lightgreen">
					<td>SID</td>
					<td>Name</td>
					<td>Email</td>
					<td>Phone</td>
				</tr>
				<c:forEach items="${LIST.studList }" var="st">
					<tr>
						<td>${st.sid }</td>
						<td>${st. name}</td>
						<td>${st.email }</td>
						<td>${st.phone }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if><br>
		
	</h1>
</html>