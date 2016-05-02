<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html><head><title>Search Contact here</title></head>
<body>
<h1><bean:message key="label.title"/> </h1>
<h1><bean:message key="label.title"/> </h1>	<br><br><br>
<h1><bean:message key="label.header"/> </h1>
<html:form action="/Search.jlc" >	<br>
<html:submit value="Search"/>
</html:form>

<hr>

<html:link forward="english">English</html:link><br><br>
<html:link forward="hindi">Hindi</html:link><br><br>

<hr>

</body>
</html>