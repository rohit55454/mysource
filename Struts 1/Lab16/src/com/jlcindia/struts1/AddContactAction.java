package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorActionForm;

public class AddContactAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("execute()ing..........AddContactAction");
		String result = "AddContactSuccess";
		
		//	1. Collect Data
		DynaValidatorActionForm acf = (DynaValidatorActionForm)af;
		
		String em = acf.get("email").toString();
		
		//	2. get from DB
		
		ContactTO cto = new ContactTO();
		cto.setFname("rohit");
		cto.setLname("sachan");
		cto.setEmail(em);
		cto.setPhone("9999999");
		
		HttpSession hs = req.getSession();
		hs.setAttribute("EDIT", "FALSE");
		req.setAttribute("CTO", cto);
		
		//	3. forward
		return am.findForward(result);
	}
}
