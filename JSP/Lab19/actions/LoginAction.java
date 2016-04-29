package com.jlc.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlc.jdbc.UserService;

public class LoginAction extends JLCBaseAction{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LoginAction Servlet");
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		int x = us.verifyUser(un, pw);
		HttpSession sess = req.getSession();
		String result = "";
		
		if(x==1){
			sess.setAttribute("UN", un);
			result = "home.jsp";
		}else{
			String msg = "Invalid UserName or Password";
			req.setAttribute("MSG", msg);
			result = "index.jsp";
		}
		
		return result;
	}
}
