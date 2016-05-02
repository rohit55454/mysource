package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ChangeEmailAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		String status = "success";
		
		System.out.println("execute()d");
		ChangeEmailForm cf = (ChangeEmailForm)af;
		System.out.println(cf.getCurrentEmail());
		System.out.println(cf.getNewEmail());
		
		return am.findForward(status);
	}
}
