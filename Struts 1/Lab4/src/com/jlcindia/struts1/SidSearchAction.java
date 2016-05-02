package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SidSearchAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//	1. Collect data
		SidSearchForm ssf = (SidSearchForm)af;
		String sid = ssf.getSid();
		
		//	2. process the request
		String result = "";
		if(sid.equals("jlc-123") || sid.equals("jlc-999")){
			StudentTO sto = new StudentTO();
			sto.setSid(sid);
			sto.setBid("B-99");
			sto.setSname("Rohit");
			sto.setEmail("rohit@gmail.com");
			sto.setPhone("999999999");
			
			result = "SidResults";
			req.setAttribute("STO", sto);
		}else{
			throw new StudentNotFoundException();
		}
		
		//	3. prepare the ActionForward
		return am.findForward(result);
	}
}
