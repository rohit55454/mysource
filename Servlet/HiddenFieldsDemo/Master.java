package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

public class Master extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet called");
		PrintWriter out = res.getWriter();
		
		HttpSession sess = req.getSession();
		
		String formno = req.getParameter("formno");
		if(formno.equals("1")){
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			sess.setAttribute("name", name);
			sess.setAttribute("email", email);
			res.sendRedirect("./form2.html");
			
		}

		if(formno.equals("2")){
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			sess.setAttribute("phone", phone);
			sess.setAttribute("email", address);
			res.sendRedirect("./form3.html");
		}

		if(formno.equals("3")){
			String age = req.getParameter("age");
			String place = req.getParameter("place");
			
			String name = (String) sess.getAttribute("name");
			String email = (String) sess.getAttribute("email");
			String phone = (String) sess.getAttribute("phone");
			String address = (String) sess.getAttribute("address");
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "toor");
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into registration values (?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, phone);
				ps.setString(4, address);
				ps.setString(5, age);
				ps.setString(6, place);
				
				int i = ps.executeUpdate();
				if(i==1){
					out.println("<pre>");
					out.println("name :"+name);
					out.println("email :"+email);
					out.println("phone :"+phone);
					out.println("address :"+address);
					out.println("age :"+age);
					out.println("place :"+place);
					out.println("</pre>");
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
