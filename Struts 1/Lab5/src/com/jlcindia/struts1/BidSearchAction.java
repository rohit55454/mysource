package com.jlcindia.struts1;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BidSearchAction extends Action{
	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//	1. Collect data
		BidSearchForm ssf = (BidSearchForm)af;
		String bid = ssf.getBid();
		
		//	2. process the request
		String result = "";
		if(bid.equals("B-12") || bid.equals("B-99")){
			List<StudentTO> list = new ArrayList<>();
			StudentTO sto = new StudentTO();
			sto.setSid("jlc-123");
			sto.setBid(bid);
			sto.setSname("Rohit");
			sto.setEmail("rohit@gmail.com");
			sto.setPhone("999999999");
			
			list.add(sto);	list.add(sto);	list.add(sto);	list.add(sto);
			list.add(sto);	list.add(sto);	list.add(sto);	list.add(sto);
			
			result = "BidResults";
			req.setAttribute("LIST", list);
		}else{
			result = "BidSearch";
			ActionErrors errors = new ActionErrors();
			errors.add("bid", new ActionError("bid.notfound"));
			saveErrors(req, errors);
		}
		
		//	3. prepare the ActionForward
		return am.findForward(result);
	}
}
