<%@ page isELIgnored="false" %>

<html><body><center>
<h1>Jlc Tech Support</h1>
<h2>Login Form</h2>
<font color="red" size="5">${MSG }</font>
<form action="register.jlc" method="post">

<table>
<tr><td>Full Name : </td><td><input type="text" name="fname"></td></tr>
<tr><td>Email	  : </td><td><input type="email" name="email"></td></tr>
<tr><td>Phone 	  :	</td><td><input type="number" name="phone"></td></tr>
<tr><td>username  :	</td><td><input type="text" name="username"></td></tr>
<tr><td>password  :	</td><td><input type="password" name="password"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="register"></td></tr>

</table></form></center></body></html>