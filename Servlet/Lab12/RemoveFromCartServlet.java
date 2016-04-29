package com.jlcindia.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RemoveFromCartServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if(sess == null){
			req.setAttribute("MSG", "session is destryoed");
		}else{
			String bnm = req.getParameter("bname");
			sess.removeAttribute(bnm);
		}
		RequestDispatcher rd = req.getRequestDispatcher("showcart.jlc");
		rd.forward(req, res);
	}
}
