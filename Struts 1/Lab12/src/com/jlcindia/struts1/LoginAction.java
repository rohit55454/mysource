package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

public class LoginAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("execute()  called");
		// 1. collect data
		DynaValidatorForm lf = (DynaValidatorForm)af;
		String un = lf.get("username").toString();
		String pw = lf.get("password").toString();
		
		// 2. contact model
		String result = "";
		if(un.equals(pw)){
			result = "success";
			req.setAttribute("UN", un);
		}
		else{
			result = "failed";
			ActionErrors errors = new ActionErrors();
			errors.add("login.invalid", new ActionError("error.login.invalid"));
			this.saveErrors(req, errors);
		}
		
		// 3. prepare the ActionForward
		return am.findForward(result);
	}
}
