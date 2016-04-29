<html>
<head>
<title>Lab 6</title>
</head>

<body>

Using useBean and other tags

<jsp:useBean id="ST1" class="com.jlc.Student"/>
<jsp:setProperty property="sid" name="ST1"/>	<hr/>
<h1>
	Sid : 	<jsp:getProperty property="sid" name="ST1"/><br>
	Name : 	<jsp:getProperty property="name" name="ST1"/><br>
	Phone : <jsp:getProperty property="phone" name="ST1"/>
<br>
</h1>

<jsp:useBean id="ST2" class="com.jlc.Student"/>
<jsp:setProperty property="*" name="ST2"/>	<hr/>
<h1>
	Sid : 	<jsp:getProperty property="sid" name="ST2"/><br>
	Name : 	<jsp:getProperty property="name" name="ST2"/><br>
	Phone : <jsp:getProperty property="phone" name="ST2"/>
<br>
</h1>


<jsp:useBean id="ST3" class="com.jlc.Student"/>
<jsp:setProperty property="sid" name="ST3"/>	<hr/>
<h1>
	Sid : 	<jsp:getProperty property="sid" name="ST3"/><br>
	Phone : <jsp:getProperty property="phone" name="ST3"/>
<br>
</h1>
</body>
</html>