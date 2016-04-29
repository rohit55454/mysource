package com.db.servlet;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ConnectMsAccessServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Connection con = null;
		Statement st;
		out.write("<html><head><title>Welcome to the world of JDBC with SERVLETS</head></html>");
		
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "C:\\bookdb.accdb");
			
			if(con!=null){
				st = con.createStatement();
				st.execute("create table books(bname varchar(50), author varchar(50))");
			}
			
			System.out.println("connection established");
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
