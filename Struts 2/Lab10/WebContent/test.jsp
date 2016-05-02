<%@ taglib uri="/struts-tags" prefix="s"%>
<html><head><s:head/> </head>
<body><center>

<h1><s:text name="label.jlc.header" /> </h1>
<h1>Annotation Vallidation Test Form </h1>
<s:actionerror/>
<s:form action="annotatedTest">
<s:textfield name="name" label="Name" cssStyle="font-size:20px; color:green" />
<s:textfield name="age" label="Age" cssStyle="font-size:20px; color:green" />
<s:textfield name="fee" label="Fee" cssStyle="font-size:20px; color:green" />
<s:textfield name="dob" label="DOB" cssStyle="font-size:20px; color:green" />
<s:textfield name="email" label="Email" cssStyle="font-size:20px; color:green" />
<s:textfield name="website" label="Website" cssStyle="font-size:20px; color:green" />
<s:submit />
</s:form>
</center>

</body>
</html>