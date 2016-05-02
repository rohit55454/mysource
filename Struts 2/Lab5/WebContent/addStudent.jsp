<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head> <s:head/> </head>
<body>

<font color="red" size="7"><s:text name="label.jlc.header" /> </font>
<h3>Add Student Form</h3>

<s:form action="AddStudentSubmit">
<s:textfield name="sname" label="Full Name" />
<s:textfield name="email" label="Email" />
<s:textfield name="phone" label="Phone" />
<s:submit value="Add Student"/>

</s:form>

</body>
</html>