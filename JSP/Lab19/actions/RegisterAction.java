package com.jlc.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.naming.factory.MailSessionFactory;

import com.jlc.mailService.MailService;
import com.jlc.to.UserTo;

public class RegisterAction extends JLCBaseAction{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("RegisterAction- service() started");
		String fn = req.getParameter("fname");
		String em = req.getParameter("email");
		String ph = req.getParameter("phone");
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		int uid = us.getNextUserId();
		long ph1 = Long.parseLong(ph);
		UserTo uo = new UserTo(uid, fn, em, ph1, un, pw);
		
		int x = us.registeruser(uo);
		HttpSession sess = req.getSession();
		String result = "";
		if(x==1){
			sess.setAttribute("UN", un);
			result = "home.jsp";
			String sub = "Registration Success !!!";
			String body = "<h1>Hi "+fn+" your registration has been completed successfully"+"</h1>";
			MailService.sendMail(em, sub, body);
		}
		else{
			String msg = "Registration Failed";
			req.setAttribute("MSG", msg);
			result = "register.jsp";
		}
		
		return result;
	}

}
