//	just copy mysql connector jar to jdk/jre/lib

package com.db.servlet;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConnectMysqlServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Connection con = null;
		Statement st = null;
		out.write("<html><head>Welcome to the world of JDBC with SERVLETS</head></html>");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/servletdb", "root", "toor");
			
			System.out.println("connection established");
			out.write("<h1><p>connection established</p></h1>");
			
			if(con!=null){
				st = con.createStatement();
				st.executeUpdate("create table books(bname varchar(50), author varchar(50))");
			}
			
			out.write("<h1><p>table created</p></h1>");
			System.out.println("table created");
			
		}catch (Exception e) {
			System.out.println("can't connect to database");
			e.printStackTrace();
		}finally{
			if(con!=null){
				try{
					con.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		out.close();

	}
}
