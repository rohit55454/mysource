<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <html> 
  <body>  <!-- <center> -->
  	
<form:form method="post" commandName="student">
<table>
	<tr><td align="center" colspan="3"><u><font color="green" size="10">Student Registration Form</font></td></tr>
	<tr><td>Student ID : </td>	<td><form:input path="sid"/></td>	<td><font color="red" size="5"><form:errors path="sid"/></font></td></tr>
	<tr><td>Student Name : </td>	<td><form:input path="sname"/></td>	<td><font color="red" size="5"><form:errors path="sname"/></font></td></tr>
	<tr><td>Student Phone : </td>	<td><form:input path="phone"/></td>	<td><font color="red" size="5"><form:errors path="phone"/></font></td></tr>
	<tr><td>Student Email : </td>	<td><form:input path="email"/></td>	<td><font color="red" size="5"><form:errors path="email"/></font></td></tr>
	
	<tr><td>Student Qualification : </td>	
		<td><form:select path="qualification"> 
			<form:option value="----Select Option----" />
			<form:option value="B.Tech." />
			<form:option value="M.Tech" />
			<form:option value="MCA" />
			</form:select>
		</td>	
		<td><font color="red" size="5"><form:errors path="qualification"/></font></td>
	</tr>
	
	<tr><td>Gender :</td>	
		<td><label><form:radiobutton path="gender" value="male"/>Male</label><br/>
			<label><form:radiobutton path="gender" value="female"/>Female</label><br/></td>
		<td><font color="red" size="5"><form:errors path="gender"/></font></td>
	</tr>					
	
	<tr><td>Remarks : </td>	
		<td> <form:textarea path="remarks" rows="5" cols="40"/></td>
		<td><font color="red" size="5"><form:errors path="remarks"/></font></td>
	</tr>	
	
	<tr></tr><tr></tr><tr></tr><tr></tr>
	
	<tr><td>Suitable Timings :</td>
		<td><label><form:checkbox path="timings" value="7:30AM - 9:30AM"/>7:30AM - 9:30AM</label><br>
			<label><form:checkbox path="timings" value="9:30AM - 11:30AM"/>9:30AM - 11:30AM</label><br>
			<label><form:checkbox path="timings" value="12:30AM - 2:30AM"/>12:30AM - 2:30AM</label><br>
			<label><form:checkbox path="timings" value="3:30AM - 5:30AM"/>3:30AM - 5:30AM</label><br>
		</td>
		<td><font color="red" size="5"><form:errors path="timings"/></font></td>
	</tr>
	
	<tr><td colspan="3"><input type="submit" value="Register Now" /></td></tr>
	
</table>

		</form:form>
	
  <!-- </center> --> </body>
</html>
