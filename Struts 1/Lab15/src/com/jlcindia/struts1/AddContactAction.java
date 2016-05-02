package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddContactAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("execute()ing..........AddContactAction");
		String result = "AddContactSuccess";
		
		//	1. Collect Data
		ContactForm acf = (ContactForm)af;
		String fn = acf.getFname();
		String ln = acf.getLname();
		String em = acf.getEmail();
		String ph = acf.getPhone();
		
		//	2. store in DB
		System.out.println(fn);
		System.out.println(ln);
		System.out.println(em);
		System.out.println(ph);
		
		ContactTO cto = new ContactTO();
		cto.setFname(fn);
		cto.setLname(ln);
		cto.setEmail(em);
		cto.setPhone(ph);
		
		req.setAttribute("CTO", cto);
		
		//	3. forward
		return am.findForward(result);
	}
}
