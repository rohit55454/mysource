<%@page import="java.io.File" %>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>

<html><head></head>
<body>

<%
	String path = application.getRealPath("/WEB-INF/files");
	File dir = new File(path);
	String files[] = dir.list();
	request.setAttribute("FILES", files);
%>

<h1>Using Request Parameter </h1><br/>
<logic:iterate id="file" name="FILES">
<html:form action="/download">
<html:hidden property="filename" value="${file }"/>	<br>
<html:submit value="Download ${file }" />
</html:form>
</logic:iterate>

</body>
</html>