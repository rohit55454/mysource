package com.jlc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguage extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String lan = req.getParameter("language");
		req.setAttribute("LAN", lan);
		req.getRequestDispatcher("result.jsp").forward(req, res);
	}
}
