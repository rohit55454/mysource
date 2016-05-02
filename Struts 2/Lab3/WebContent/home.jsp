<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>	<s:head/>	</head>
<body>

<s:url id="hellourl" action='jlcindia/Hello.action' />
<s:url id="haiurl" action='jlcindia/Hai.action' />
<s:url id="hellohaiurl" action='jlcindia/HelloHai.action' />
<s:url id="testurl" action='jlcindia/Test.action' />
<s:url id="dtesturl1" action='jlcindia/DTest1.action' />
<s:url id="dtesturl2" action='jlcindia/DTest2.action' />

<h1>

Hello ! <s:property value="username"/> <br>Welcome to JLC 	<br>

<s:a href="%{hellourl}" > click here for HelloURL Action</s:a>	<br>
<s:a href="%{haiurl}" > click here for HaiURL Action</s:a>	<br>
<s:a href="%{hellohaiurl}" > click here for HelloHaiURL Action</s:a>	<br>
<s:a href="%{testurl}" > click here for test Action</s:a>	<br>
<s:a href="%{dtesturl1}" > click here for DTest1 Action--test1()</s:a>	<br>
<s:a href="%{dtesturl2}" > click here for DTest2 Action--test2()</s:a>	<br>

</h1>

</body>
</html>
