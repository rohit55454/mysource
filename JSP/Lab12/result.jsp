<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${LAN }" scope="session"/>
<fmt:setBundle basename="message" scope="session"/>

<html><body><h1>
<fmt:formatDate value="<%=new Date() %>" pattern="dd-mm-yyyy"/><br>
<fmt:formatDate value="<%=new Date() %>" pattern="dd-mm-yyyy hh:mm:ss"/><br>

<fmt:message key="header"/><br>
<a href="index.html">Back</a>
</h1>

</body></html>