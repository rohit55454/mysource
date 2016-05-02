package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

public class AddContactAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("execute()ing..........AddContactAction");
		String result = "AddContactSuccess";
		
		//	1. Collect Data
		DynaValidatorForm dvf = (DynaValidatorForm)af;
		String fn = dvf.get("fname").toString();
		String ln = dvf.get("lname").toString();
		String em = dvf.get("email").toString();
		String ph = dvf.get("phone").toString();
		
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
