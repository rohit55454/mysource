<%@ taglib prefix="jlc" uri="/WEB-INF/jlcindia.tld" %>

<html><body>
<h1>
<jlc:if test="true"><br>First If Block</jlc:if>	<hr>
<jlc:if test="false"><br>Second If Block</jlc:if>	<hr>
<jlc:if test="${10 eq 12 }"><br> Third If Block</jlc:if> <hr>
<jlc:if test="${10 eq 10 }"><br> Same values</jlc:if> <hr>

</h1>
</body>
</html>