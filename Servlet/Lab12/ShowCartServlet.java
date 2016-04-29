package com.jlcindia.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowCartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if(sess == null){
			req.setAttribute("MSG", "Session is destroyed");
			RequestDispatcher rd = req.getRequestDispatcher("showbooks.jsp");
			rd.forward(req, res);
		}
		else{
			Enumeration<String> enms = sess.getAttributeNames();
			List<String> selectedlist = Collections.list(enms);
			selectedlist.remove("BOOKS");

			if(selectedlist.size() == 0){
				req.setAttribute("MSG", "NO BOOKS SELECTED");
			}else{
				req.setAttribute("CART", selectedlist);
			}
			RequestDispatcher rd = req.getRequestDispatcher("showcart.jsp");
			rd.forward(req, res);
		}
	}
}
