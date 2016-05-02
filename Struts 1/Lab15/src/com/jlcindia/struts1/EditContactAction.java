package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EditContactAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		String result = "SearchResults";
		System.out.println("execute()ing.......EditContactAction");
		HttpSession hs = req.getSession();
		hs.setAttribute("EDIT", "TRUE");
		
		return am.findForward(result);
	}
}
