package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.validator.DynaValidatorForm;

//struts 2

public class ContactAction extends MappingDispatchAction{ 
	public ActionForward addContact(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res){
		System.out.println("addContact()......");
		String result = "AddContactSuccess";
		
		//	1. collect data
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
		
		// 3. forward
		return am.findForward(result);
	}
	
	public ActionForward editContact(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res){
		System.out.println("editContact()........");
		String result = "SearchResults";
		HttpSession hs = req.getSession();
		hs.setAttribute("EDIT", "TRUE");
		
		return am.findForward(result);
	}

	public ActionForward searchContact(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res){
		System.out.println("searchContact()........");
		String result = "SearchResults";
		
		//	1. collect data
		DynaValidatorForm dvf = (DynaValidatorForm)af;
		String em = dvf.get("email").toString();
		
		//	2. get from DB
		System.out.println(em);
		ContactTO cto = new ContactTO();
		cto.setFname("rohit");
		cto.setLname("sachan");
		cto.setEmail(em);
		cto.setPhone("88888888");
		
		HttpSession hs = req.getSession();
		hs.setAttribute("CTO", cto);
		hs.setAttribute("EDIT", "FALSE");
		
		//	3.forward
		return am.findForward(result);
	}

	public ActionForward updateContact(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res){
		System.out.println("updateContact()......");
		String result = "UpdateContactSuccess";
		
		//	1. collect data
		DynaValidatorForm dvf = (DynaValidatorForm)af;
		String fn = dvf.get("fname").toString();
		String ln = dvf.get("lname").toString();
		String em = dvf.get("email").toString();
		String ph = dvf.get("phone").toString();
		
		//	2. update in DB
		System.out.println(fn);
		System.out.println(ln);
		System.out.println(em);
		System.out.println(ph);
		
		
		// 3. forward
		return am.findForward(result);
	}
}
