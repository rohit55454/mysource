<html><body><h1>
Student Name :	${param.sname}<br>
primary email :	${param.email }<br>
primary email :	${paramValues.email[0] }<br>
Second Email :	${paramValues.email[1] }<br>
<hr>
Host :			${header.host }<br>
Referer :		${header.referer }<br>
jsessionId Cookie : ${cookie.JSESSIONID.value }<br>
Email cookie :		${cookie.email.value }<br>
Phone cookie :		${cookie.phone.value }<br>

CP State : 			${initparam.state }<br>
CP city : 			${initparam.city }<br>
<hr>
<h2>Using PageContext</h2><br>
${pageContext.session.id }<br>
${pageContext.request.remoteAddr }<br>
${pageContext.request.method}<br>
${pageContext.request.requestURI}<br>
${pageContext.response.contentType}<br>

</h1>
</body></html>
