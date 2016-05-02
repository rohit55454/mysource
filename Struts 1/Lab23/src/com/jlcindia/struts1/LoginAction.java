package com.jlcindia.struts1;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. collect data
		LoginForm lf = (LoginForm)af;
		String un = lf.getUsername();
		String pw = lf.getPassword();
		
		// 2. process the request
		String result = "";
		if(un.equals(pw)){
			result = "home";
			req.setAttribute("UN", un);
		}
		else{
			result = "login";
			String msg = "invalid Username OR Password";
			req.setAttribute("EMSG", msg);
		}
		
		// 3. prepare the ActionForward
		ActionForward forward = am.findForward(result);
		return forward;
	}
}
