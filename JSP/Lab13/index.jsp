<!--add jstl1.2.jar to project build path  -->
<%@taglib prefix="jlc" uri="http://jlcindia.com/ctags"%>

<html>
<body>
	<h1>Custom Tag Example</h1>
	<jlc:showMessage sname="Sri" email="sri@jlc.com" />
	<hr>
	<jlc:showMessage sname="nivas" />
	<hr>
	<jlc:showMessage sname="" />
	<hr>

</body>
</html>