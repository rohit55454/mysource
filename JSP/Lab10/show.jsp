<%--@ taglib uri="http://www.java.sun.com/jsp/jstl/core" prefix="c" --%>
<html>
<body>
<table border="2" style="font-size:26;color:red">

<tr><td><h1>1. String wrappers Date</h1>
<td><c:out value="${requestScope.EM }"/>	<br>
${sessionScope.PH }<br>
${applicationScope.DOB }<br></td></tr></table>

<hr><h1>2. Collection of String wrappers Date</h1>
<c:foreach var="x" items="${requestScope.Al }">........${x }
</c:foreach>
<br>
<c:foreach var="x" items="${requestScope.STR }">........${x }
</c:foreach>

<hr><h1>3. Collection of Collections</h1>
<c:foreach var="list" items="${requestScope.AL1 }">
<c:foreach var="x" items="${list }">........${x }
</c:foreach>
</c:foreach>

<hr><h1>4. Custom or User defined class Object</h1><br>
cid :		${CUST.cid }<br>
cname :		${sessionScope.CUST.cname }<br>
email :		${sessionScope.CUST.email }<br>
phone :		${sessionScope.CUST.phone }<br>
Accno :		${sessionScope.CUST.account.accno }<br>
Atype :		${sessionScope.CUST.account.atype }<br>
bal :		${sessionScope.CUST.account.bal }<br>
Sreet :		${sessionScope.CUST.account.address.street }<br>
City :		${sessionScope.CUST.account.address.city }<br>

<hr><h1>5. collection of Custom or User defined class Object</h1><br>

<table>
<tr><td>cid</td><td>cname</td><td>email</td><td>phone</td><td>Accno</td><td>Atype</td>
<td>street</td><td>city</td></tr>
<c:foreach var="cust" items="${sessionScope.CS }">
<tr>
<td>${cust.cid }</td>
<td>${cust.cname }</td>
<td>${cust.email }</td>
<td>${cust.phone }</td>
<td>${cust.account.accno }</td>
<td>${cust.account.atype }</td>
<td>${cust.address.street }</td>
<td>${cust.address.city }</td>
</c:foreach>
</table>

<hr><h1>6. Map Object</h1><br>
<table>
<tr>
<td>map key</td><td>Map value</td></tr>
<c:foreach var="entry" items="${sessionScope.HM }">
<tr><td>${entry.key }</td><td>${entry.value }</td></tr>
</c:foreach>
</table>

<hr><h1>7.Collection of Map Object</h1><br>
<c:foreach var="map" items="${sessionScope.AL2 }">
<table>
<tr>
<td>map key</td><td>Map value</td></tr>
<c:foreach var="entry" items="${map }">
<tr><td>${entry.key }</td><td>${entry.value }</td></tr>
</c:foreach>
</c:foreach>
</table>


</body></html>