package com.jlcindia.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddToCartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if(sess == null){
			req.setAttribute("MSG", "Session is Destroyed");
		}else{
			String bnm = req.getParameter("bname");
			sess.setAttribute(bnm, bnm);
			req.setAttribute("ADDED", bnm+" Added to cart");
		}
		RequestDispatcher rd = req.getRequestDispatcher("showbooks.jsp");
		rd.forward(req, res);
	}
}
