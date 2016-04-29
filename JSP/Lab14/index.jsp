<%@ taglib prefix="jlc" uri="/WEB-INF/jlcindia.tld" %>

<html><body>
<form action="test.jlc" method="post">
<table align="center">

<tr>
<td><h2>Enter name : </h2></td>		<td><input type="text" name="fname"></td>
<td><jlc:error property="fname"/></td>
</tr>

<tr>
<td><h2>Enter email : </h2></td>	<td><input type="text" name="email"></td>
<td><jlc:error property="email"/></td>
</tr>
<th align="center"><input type="submit" value="Submit">
</th>
</table>

</form>

</body>
</html>