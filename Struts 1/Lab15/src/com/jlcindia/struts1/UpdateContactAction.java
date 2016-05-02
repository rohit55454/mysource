package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UpdateContactAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		String result = "UpdateContactSuccess";
		System.out.println("execute()ing.......UpdateContactAction");
		
		//	1. collect data
		ContactForm acf = (ContactForm)af;
		String fn = acf.getFname();
		String ln = acf.getLname();
		String em = acf.getEmail();
		String ph = acf.getPhone();
		
		//	2. update in DB
		System.out.println(fn);
		System.out.println(ln);
		System.out.println(em);
		System.out.println(ph);
		
		return am.findForward(result);
	}
}
