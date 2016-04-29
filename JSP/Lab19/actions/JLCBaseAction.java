package com.jlc.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.jdbc.UserService;

public abstract class JLCBaseAction {
	static UserService us = null;
	static{
		us = new UserService();
	}
	
	public abstract String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	
}
