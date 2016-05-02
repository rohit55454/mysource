package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

public class UpdateContactAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		String result = "UpdateContactSuccess";
		System.out.println("execute()ing.......UpdateContactAction");
		
		//	1. collect data
		DynaValidatorForm acf = (DynaValidatorForm)af;
		String fn = acf.get("fname").toString();
		String ln = acf.get("lname").toString();
		String em = acf.get("email").toString();
		String ph = acf.get("phone").toString();
		
		//	2. update in DB
		System.out.println(fn);
		System.out.println(ln);
		System.out.println(em);
		System.out.println(ph);
		
		return am.findForward(result);
	}
}
