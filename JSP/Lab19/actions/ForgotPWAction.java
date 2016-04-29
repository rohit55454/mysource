package com.jlc.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.mailService.MailService;


public class ForgotPWAction extends JLCBaseAction{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String em = req.getParameter("email");
		String pw = us.getPasswordByEmail(em);
		String result = "";
		if(pw != null){
			result = "pwstatus.jsp";
			String sub = "Your password is here...";
			String body = "<h1>Hi your Password is : "+pw+"</h1>";
			MailService.sendMail(em, sub, body);
		}
		else{
			String msg = "Invalid mail---try Again";
			req.setAttribute("MSG", msg);
			result = "forgotpw.jsp";
		}
		
		return result;
	}

}
