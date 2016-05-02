package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SearchContactAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		String result = "SearchResults";
		System.out.println("execute()ing.......SearchContactAction");

		//	1. collect data
		SearchContactForm scf = (SearchContactForm)af;
		String em = scf.getEmail();

		//	2. get from DB
		System.out.println(em);
		
		ContactTO cto = new ContactTO();
		cto.setFname("rohit");
		cto.setLname("sachan");
		cto.setEmail(em);
		cto.setPhone("1111111");
		
		HttpSession hs = req.getSession();
		hs.setAttribute("CTO", cto);
		hs.setAttribute("EDIT", "FALSE");
		
		return am.findForward(result);
	}
}
