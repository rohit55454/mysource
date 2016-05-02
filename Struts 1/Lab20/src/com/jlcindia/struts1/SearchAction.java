package com.jlcindia.struts1;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

//struts 2

public class SearchAction extends Action{ 
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		DynaActionForm daf = (DynaActionForm)af;
		String h = daf.get("hello").toString();
		System.out.println(h);
		HttpSession hs = req.getSession();
		
		Locale lo = (Locale)hs.getAttribute(Globals.LOCALE_KEY);
		System.out.println("your current Locale : "+lo.getLanguage());
		
		return am.findForward("results");

	}
}