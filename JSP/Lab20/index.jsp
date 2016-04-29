<%@ page import="java.io.File"%>
<html><body>
<%
	String path = request.getRealPath("/");
	path = path + "WEB-INF/files";
	File dir = new File(path);
	String str[] = dir.list();
	if(str.length == 0){
 %>

<font color="red" size="5">No Files To Download</font>

<%
	}else{
		for(int i=0; i<str.length; i++){
		String fnm = str[i];
 %>
 
 <br><%=fnm %> : <a href="download.jlc?filename=<%=fnm%>">Download</a>
 
 <%
		}
	}
 %>

</body></html>