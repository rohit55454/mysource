<html><body>
<h1>1. String, Wrappers and Date</h1><br>
${requestScope.EM }<br>
${sessionScope.PH }<br>
${applicationScope.DOB }<br>
<hr>
<h1>// 2. Collection of String, Wrappers and Date</h1><br>
${requestScope.AL[0] }<br>
${requestScope.AL[1] }<br>
${requestScope.AL[2] }<br>
${requestScope.AL[3] }<br>
${requestScope.AL[4] }<br><br>

${sessionScope.STR[0] }<br>
${sessionScope.STR[1] }<br>
${sessionScope.STR[2] }<br>
${sessionScope.STR[3] }<br><br>

<hr><h1>// 3. Collection of Collections(*JSTL)</h1><br>
<h2>Coming soon</h2>

<hr><h1>	// 4. Custom or user Defined class Object</h1><br>
cid :		${CUST.cid }<br>
cname :		${sessionScope.CUST.cname }<br>
email :		${sessionScope.CUST.email }<br>
phone :		${sessionScope.CUST.phone }<br>
Accno :		${sessionScope.CUST.account.accno }<br>
Atype :		${sessionScope.CUST.account.atype }<br>
Bal :		${sessionScope.CUST.account.bal }<br>
Street :	${sessionScope.CUST.account.address.street }<br>
city :		${sessionScope.CUST.account.address.city }<br>

<hr>
<h1>	// 5. Collection of user Defined class Objects</h1><br>
cid :		${CS[0].cid }<br>
cname :		${sessionScope.CS[0].cname }<br>
email :		${sessionScope.CS[0].email }<br>
phone :		${sessionScope.CS[0].phone }<br>
Accno :		${sessionScope.CS[0].account.accno }<br>
atype :		${sessionScope.CS[0].account.atype }<br>
Bal :		${sessionScope.CS[0].account.bal }<br>
Street :	${sessionScope.CS[0].account.address.street }<br>
City :		${sessionScope.CS[0].account.address.city }<br>

<h1>	// 6. map Objects</h1><br>
sid :		${sessionScope.HM["sid"] }<br>
sname :		${sessionScope.HM["sname"] }<br>
email :		${sessionScope.HM["email"] }<br>

<h1>	// 7.Collection of map Objects</h1><br>

<h2>coming soon</h2>

</body> </html>