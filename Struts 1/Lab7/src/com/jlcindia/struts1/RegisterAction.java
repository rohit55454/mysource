package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegisterAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("execute()  called");
		// 1. collect data
		RegisterForm rf = (RegisterForm)af;
		System.out.println(rf.getSname());
		System.out.println(rf.getEmail());
		System.out.println(rf.getDob());
		System.out.println(rf.getDor());
		
		return am.findForward("home");
	}
}
