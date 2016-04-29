package com.jlcindia.servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SearchBookServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cat=req.getParameter("catagory");
		if(cat!=null && cat.equals("java")){
			ArrayList<String> blist = new ArrayList<>();
			blist.add("java");
			blist.add("jdbc");
			blist.add("Servlets");
			blist.add("jsp");
			blist.add("ejb");
			blist.add("rmi");

			HttpSession sess = req.getSession();
			sess.setAttribute("BOOKS", blist);
		}else{
			req.setAttribute("MSG", "No Books Found in Store with this catagory");
		}
		RequestDispatcher rd = req.getRequestDispatcher("showbooks.jsp");
		rd.forward(req, res);
	}
}
