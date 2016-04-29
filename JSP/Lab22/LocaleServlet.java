package com.jlc.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="localeServlet", urlPatterns={"/changelocale.jlc"})

public class LocaleServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String lan = req.getParameter("language");
		Locale loc = new Locale(lan);
		res.setLocale(loc);
		req.getSession().setAttribute("LAN", lan);
		req.getRequestDispatcher("index.jsp").forward(req, res);
		System.out.println(lan);
	}
}
