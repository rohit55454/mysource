<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>

<html><head></head>
<body>
<h1>Upload File</h1>
<html:form action="/Upload" enctype="multipart/form-data">
<table>
<tr><td>Enter Email</td>	<td><html:text property="email" /></td></tr>
<tr><td>browse the file to upload</td>	<td><html:file property="myfile" /></td></tr>
<tr><td><html:submit value="Upload" /></td></tr>

</table>

</html:form>

</body>
</html>