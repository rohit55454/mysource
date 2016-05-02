<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html><head><title>Home</title></head>
<body>
<h1><bean:message key="label.jlcheader"/> </h1>
<h2><html:link forward="SidSearch">Search Student by SiD</html:link> </h2>
<h2><html:link forward="BidSearch">Search Student by BiD</html:link> </h2>

</body>
</html>