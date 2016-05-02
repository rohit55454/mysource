<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>home.jsp</title>
</head>
<body>

<s:url id="addstudent" action="AddStudentDisplay" />
<s:url id="sidsearch" action="SidSearchDisplay" />
<s:url id="bidsearch" action="BidSearchDisplay" />

<h1><s:a href="%{addstudent}">Add Student </s:a></h1>
<h1><s:a href="%{sidsearch}">Search Student by sid </s:a></h1>
<h1><s:a href="%{bidsearch}">Search Student by bid </s:a></h1>

</body>
</html>