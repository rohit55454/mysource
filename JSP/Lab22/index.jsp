<!--add jstl1.2.jar to project build path  -->
<%@page autoFlush="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="messages" scope="session"/>
<fmt:setLocale value="${LAN }" scope="session"/>

<html><body>
<h1 align="center">
<fmt:message key="welcome.header"/>
</h1><br><br><br>

<h2 align="center">
<a href="changelocale.jlc?language=en">   <fmt:message key="language.english"/> </a> |
<a href="changelocale.jlc?language=hi">  <fmt:message key="language.hindi"/> </a>
</h2>
</body></html>